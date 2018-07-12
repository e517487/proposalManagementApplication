import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';
import { Record99EndMySuffixService } from './record-99-end-my-suffix.service';

@Component({
    selector: 'jhi-record-99-end-my-suffix-delete-dialog',
    templateUrl: './record-99-end-my-suffix-delete-dialog.component.html'
})
export class Record99EndMySuffixDeleteDialogComponent {
    record99End: IRecord99EndMySuffix;

    constructor(
        private record99EndService: Record99EndMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record99EndService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record99EndListModification',
                content: 'Deleted an record99End'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-99-end-my-suffix-delete-popup',
    template: ''
})
export class Record99EndMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record99End }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record99EndMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record99End = record99End;
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
