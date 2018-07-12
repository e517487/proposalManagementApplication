import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';
import { Record10AanvraagGegevensAlgemeenService } from './record-10-aanvraag-gegevens-algemeen.service';

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-delete-dialog',
    templateUrl: './record-10-aanvraag-gegevens-algemeen-delete-dialog.component.html'
})
export class Record10AanvraagGegevensAlgemeenDeleteDialogComponent {
    record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen;

    constructor(
        private record10AanvraagGegevensAlgemeenService: Record10AanvraagGegevensAlgemeenService,
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
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-delete-popup',
    template: ''
})
export class Record10AanvraagGegevensAlgemeenDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record10AanvraagGegevensAlgemeen }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record10AanvraagGegevensAlgemeenDeleteDialogComponent as Component, {
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
