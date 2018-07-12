import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-my-suffix-delete-dialog',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-my-suffix-delete-dialog.component.html'
})
export class Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent {
    record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingenMySuffix;

    constructor(
        private record11AanvraagGegevensOpmerkingenService: Record11AanvraagGegevensOpmerkingenMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record11AanvraagGegevensOpmerkingenService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record11AanvraagGegevensOpmerkingenListModification',
                content: 'Deleted an record11AanvraagGegevensOpmerkingen'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-my-suffix-delete-popup',
    template: ''
})
export class Record11AanvraagGegevensOpmerkingenMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record11AanvraagGegevensOpmerkingen }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingen;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
