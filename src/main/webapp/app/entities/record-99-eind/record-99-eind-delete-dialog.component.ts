import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord99Eind } from 'app/shared/model/record-99-eind.model';
import { Record99EindService } from './record-99-eind.service';

@Component({
    selector: 'jhi-record-99-eind-delete-dialog',
    templateUrl: './record-99-eind-delete-dialog.component.html'
})
export class Record99EindDeleteDialogComponent {
    record99Eind: IRecord99Eind;

    constructor(
        private record99EindService: Record99EindService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record99EindService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record99EindListModification',
                content: 'Deleted an record99Eind'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-99-eind-delete-popup',
    template: ''
})
export class Record99EindDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record99Eind }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record99EindDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record99Eind = record99Eind;
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
