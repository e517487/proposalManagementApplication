import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from './fdn-aanvrager-my-suffix.service';

@Component({
    selector: 'jhi-fdn-aanvrager-my-suffix-delete-dialog',
    templateUrl: './fdn-aanvrager-my-suffix-delete-dialog.component.html'
})
export class FdnAanvragerMySuffixDeleteDialogComponent {
    fdnAanvrager: IFdnAanvragerMySuffix;

    constructor(
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.fdnAanvragerService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'fdnAanvragerListModification',
                content: 'Deleted an fdnAanvrager'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-fdn-aanvrager-my-suffix-delete-popup',
    template: ''
})
export class FdnAanvragerMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ fdnAanvrager }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(FdnAanvragerMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.fdnAanvrager = fdnAanvrager;
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
