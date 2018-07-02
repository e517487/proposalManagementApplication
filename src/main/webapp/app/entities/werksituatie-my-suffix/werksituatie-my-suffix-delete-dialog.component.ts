import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';
import { WerksituatieMySuffixService } from './werksituatie-my-suffix.service';

@Component({
    selector: 'jhi-werksituatie-my-suffix-delete-dialog',
    templateUrl: './werksituatie-my-suffix-delete-dialog.component.html'
})
export class WerksituatieMySuffixDeleteDialogComponent {
    werksituatie: IWerksituatieMySuffix;

    constructor(
        private werksituatieService: WerksituatieMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.werksituatieService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'werksituatieListModification',
                content: 'Deleted an werksituatie'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-werksituatie-my-suffix-delete-popup',
    template: ''
})
export class WerksituatieMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ werksituatie }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(WerksituatieMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.werksituatie = werksituatie;
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
