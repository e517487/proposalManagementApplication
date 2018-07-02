import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ILegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';
import { LegitimatiebewijsMySuffixService } from './legitimatiebewijs-my-suffix.service';

@Component({
    selector: 'jhi-legitimatiebewijs-my-suffix-delete-dialog',
    templateUrl: './legitimatiebewijs-my-suffix-delete-dialog.component.html'
})
export class LegitimatiebewijsMySuffixDeleteDialogComponent {
    legitimatiebewijs: ILegitimatiebewijsMySuffix;

    constructor(
        private legitimatiebewijsService: LegitimatiebewijsMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.legitimatiebewijsService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'legitimatiebewijsListModification',
                content: 'Deleted an legitimatiebewijs'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-legitimatiebewijs-my-suffix-delete-popup',
    template: ''
})
export class LegitimatiebewijsMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ legitimatiebewijs }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(LegitimatiebewijsMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.legitimatiebewijs = legitimatiebewijs;
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
