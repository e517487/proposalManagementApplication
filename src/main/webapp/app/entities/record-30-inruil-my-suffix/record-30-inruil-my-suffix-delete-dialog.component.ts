import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';
import { Record30InruilMySuffixService } from './record-30-inruil-my-suffix.service';

@Component({
    selector: 'jhi-record-30-inruil-my-suffix-delete-dialog',
    templateUrl: './record-30-inruil-my-suffix-delete-dialog.component.html'
})
export class Record30InruilMySuffixDeleteDialogComponent {
    record30Inruil: IRecord30InruilMySuffix;

    constructor(
        private record30InruilService: Record30InruilMySuffixService,
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
    selector: 'jhi-record-30-inruil-my-suffix-delete-popup',
    template: ''
})
export class Record30InruilMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record30Inruil }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record30InruilMySuffixDeleteDialogComponent as Component, {
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
