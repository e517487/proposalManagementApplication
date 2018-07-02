import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';
import { RekenmoduleAanvraagMySuffixService } from './rekenmodule-aanvraag-my-suffix.service';

@Component({
    selector: 'jhi-rekenmodule-aanvraag-my-suffix-delete-dialog',
    templateUrl: './rekenmodule-aanvraag-my-suffix-delete-dialog.component.html'
})
export class RekenmoduleAanvraagMySuffixDeleteDialogComponent {
    rekenmoduleAanvraag: IRekenmoduleAanvraagMySuffix;

    constructor(
        private rekenmoduleAanvraagService: RekenmoduleAanvraagMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.rekenmoduleAanvraagService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'rekenmoduleAanvraagListModification',
                content: 'Deleted an rekenmoduleAanvraag'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-rekenmodule-aanvraag-my-suffix-delete-popup',
    template: ''
})
export class RekenmoduleAanvraagMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ rekenmoduleAanvraag }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(RekenmoduleAanvraagMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.rekenmoduleAanvraag = rekenmoduleAanvraag;
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
