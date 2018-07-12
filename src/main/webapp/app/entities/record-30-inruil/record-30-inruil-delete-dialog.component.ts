import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord30Inruil } from 'app/shared/model/record-30-inruil.model';
import { Record30InruilService } from './record-30-inruil.service';

@Component({
    selector: 'jhi-record-30-inruil-delete-dialog',
    templateUrl: './record-30-inruil-delete-dialog.component.html'
})
export class Record30InruilDeleteDialogComponent {
    record30Inruil: IRecord30Inruil;

    constructor(
        private record30InruilService: Record30InruilService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record30InruilService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record30InruilListModification',
                content: 'Deleted an record30Inruil'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-30-inruil-delete-popup',
    template: ''
})
export class Record30InruilDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record30Inruil }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record30InruilDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record30Inruil = record30Inruil;
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
