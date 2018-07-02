import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';
import { AlgemeenMySuffixService } from './algemeen-my-suffix.service';

@Component({
    selector: 'jhi-algemeen-my-suffix-delete-dialog',
    templateUrl: './algemeen-my-suffix-delete-dialog.component.html'
})
export class AlgemeenMySuffixDeleteDialogComponent {
    algemeen: IAlgemeenMySuffix;

    constructor(
        private algemeenService: AlgemeenMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.algemeenService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'algemeenListModification',
                content: 'Deleted an algemeen'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-algemeen-my-suffix-delete-popup',
    template: ''
})
export class AlgemeenMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ algemeen }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AlgemeenMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.algemeen = algemeen;
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
