import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';
import { Record35ObjectMySuffixService } from './record-35-object-my-suffix.service';

@Component({
    selector: 'jhi-record-35-object-my-suffix-delete-dialog',
    templateUrl: './record-35-object-my-suffix-delete-dialog.component.html'
})
export class Record35ObjectMySuffixDeleteDialogComponent {
    record35Object: IRecord35ObjectMySuffix;

    constructor(
        private record35ObjectService: Record35ObjectMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record35ObjectService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record35ObjectListModification',
                content: 'Deleted an record35Object'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-35-object-my-suffix-delete-popup',
    template: ''
})
export class Record35ObjectMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record35Object }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record35ObjectMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record35Object = record35Object;
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
