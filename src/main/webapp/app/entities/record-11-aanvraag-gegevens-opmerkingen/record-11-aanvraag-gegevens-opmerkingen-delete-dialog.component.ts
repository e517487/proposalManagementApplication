import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';
import { Record11AanvraagGegevensOpmerkingenService } from './record-11-aanvraag-gegevens-opmerkingen.service';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-delete-dialog',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-delete-dialog.component.html'
})
export class Record11AanvraagGegevensOpmerkingenDeleteDialogComponent {
    record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingen;

    constructor(
        private record11AanvraagGegevensOpmerkingenService: Record11AanvraagGegevensOpmerkingenService,
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
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-delete-popup',
    template: ''
})
export class Record11AanvraagGegevensOpmerkingenDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record11AanvraagGegevensOpmerkingen }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record11AanvraagGegevensOpmerkingenDeleteDialogComponent as Component, {
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
