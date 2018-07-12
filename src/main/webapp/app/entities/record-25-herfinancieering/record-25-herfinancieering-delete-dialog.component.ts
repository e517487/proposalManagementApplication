import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';
import { Record25HerfinancieeringService } from './record-25-herfinancieering.service';

@Component({
    selector: 'jhi-record-25-herfinancieering-delete-dialog',
    templateUrl: './record-25-herfinancieering-delete-dialog.component.html'
})
export class Record25HerfinancieeringDeleteDialogComponent {
    record25Herfinancieering: IRecord25Herfinancieering;

    constructor(
        private record25HerfinancieeringService: Record25HerfinancieeringService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record25HerfinancieeringService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record25HerfinancieeringListModification',
                content: 'Deleted an record25Herfinancieering'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-25-herfinancieering-delete-popup',
    template: ''
})
export class Record25HerfinancieeringDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record25Herfinancieering }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record25HerfinancieeringDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record25Herfinancieering = record25Herfinancieering;
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
