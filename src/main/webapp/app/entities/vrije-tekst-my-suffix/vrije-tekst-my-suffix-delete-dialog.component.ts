import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';
import { VrijeTekstMySuffixService } from './vrije-tekst-my-suffix.service';

@Component({
    selector: 'jhi-vrije-tekst-my-suffix-delete-dialog',
    templateUrl: './vrije-tekst-my-suffix-delete-dialog.component.html'
})
export class VrijeTekstMySuffixDeleteDialogComponent {
    vrijeTekst: IVrijeTekstMySuffix;

    constructor(
        private vrijeTekstService: VrijeTekstMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.vrijeTekstService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'vrijeTekstListModification',
                content: 'Deleted an vrijeTekst'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vrije-tekst-my-suffix-delete-popup',
    template: ''
})
export class VrijeTekstMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ vrijeTekst }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(VrijeTekstMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.vrijeTekst = vrijeTekst;
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
