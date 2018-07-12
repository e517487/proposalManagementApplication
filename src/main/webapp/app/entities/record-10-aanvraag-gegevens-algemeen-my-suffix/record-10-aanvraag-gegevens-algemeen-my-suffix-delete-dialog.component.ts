import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';
import { Record10AanvraagGegevensAlgemeenMySuffixService } from './record-10-aanvraag-gegevens-algemeen-my-suffix.service';

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-my-suffix-delete-dialog',
    templateUrl: './record-10-aanvraag-gegevens-algemeen-my-suffix-delete-dialog.component.html'
})
export class Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent {
    record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeenMySuffix;

    constructor(
        private record10AanvraagGegevensAlgemeenService: Record10AanvraagGegevensAlgemeenMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record10AanvraagGegevensAlgemeenService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record10AanvraagGegevensAlgemeenListModification',
                content: 'Deleted an record10AanvraagGegevensAlgemeen'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-my-suffix-delete-popup',
    template: ''
})
export class Record10AanvraagGegevensAlgemeenMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record10AanvraagGegevensAlgemeen }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeen;
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
