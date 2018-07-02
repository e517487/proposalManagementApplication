import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';
import { RequestMySuffixService } from './request-my-suffix.service';

@Component({
    selector: 'jhi-request-my-suffix-delete-dialog',
    templateUrl: './request-my-suffix-delete-dialog.component.html'
})
export class RequestMySuffixDeleteDialogComponent {
    request: IRequestMySuffix;

    constructor(
        private requestService: RequestMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.requestService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'requestListModification',
                content: 'Deleted an request'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-request-my-suffix-delete-popup',
    template: ''
})
export class RequestMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ request }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(RequestMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.request = request;
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
