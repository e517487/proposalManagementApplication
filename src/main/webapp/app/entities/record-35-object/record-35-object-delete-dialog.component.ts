import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord35Object } from 'app/shared/model/record-35-object.model';
import { Record35ObjectService } from './record-35-object.service';

@Component({
    selector: 'jhi-record-35-object-delete-dialog',
    templateUrl: './record-35-object-delete-dialog.component.html'
})
export class Record35ObjectDeleteDialogComponent {
    record35Object: IRecord35Object;

    constructor(
        private record35ObjectService: Record35ObjectService,
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
    selector: 'jhi-record-35-object-delete-popup',
    template: ''
})
export class Record35ObjectDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record35Object }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record35ObjectDeleteDialogComponent as Component, {
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
