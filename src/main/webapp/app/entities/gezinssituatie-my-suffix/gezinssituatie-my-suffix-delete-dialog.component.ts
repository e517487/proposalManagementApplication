import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IGezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';
import { GezinssituatieMySuffixService } from './gezinssituatie-my-suffix.service';

@Component({
    selector: 'jhi-gezinssituatie-my-suffix-delete-dialog',
    templateUrl: './gezinssituatie-my-suffix-delete-dialog.component.html'
})
export class GezinssituatieMySuffixDeleteDialogComponent {
    gezinssituatie: IGezinssituatieMySuffix;

    constructor(
        private gezinssituatieService: GezinssituatieMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.gezinssituatieService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'gezinssituatieListModification',
                content: 'Deleted an gezinssituatie'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-gezinssituatie-my-suffix-delete-popup',
    template: ''
})
export class GezinssituatieMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ gezinssituatie }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(GezinssituatieMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.gezinssituatie = gezinssituatie;
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
