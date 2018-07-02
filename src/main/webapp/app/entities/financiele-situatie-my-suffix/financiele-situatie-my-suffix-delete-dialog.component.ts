import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IFinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';
import { FinancieleSituatieMySuffixService } from './financiele-situatie-my-suffix.service';

@Component({
    selector: 'jhi-financiele-situatie-my-suffix-delete-dialog',
    templateUrl: './financiele-situatie-my-suffix-delete-dialog.component.html'
})
export class FinancieleSituatieMySuffixDeleteDialogComponent {
    financieleSituatie: IFinancieleSituatieMySuffix;

    constructor(
        private financieleSituatieService: FinancieleSituatieMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.financieleSituatieService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'financieleSituatieListModification',
                content: 'Deleted an financieleSituatie'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-financiele-situatie-my-suffix-delete-popup',
    template: ''
})
export class FinancieleSituatieMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ financieleSituatie }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(FinancieleSituatieMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.financieleSituatie = financieleSituatie;
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
