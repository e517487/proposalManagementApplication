import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';
import { TekstRegelMySuffixService } from './tekst-regel-my-suffix.service';

@Component({
    selector: 'jhi-tekst-regel-my-suffix-delete-dialog',
    templateUrl: './tekst-regel-my-suffix-delete-dialog.component.html'
})
export class TekstRegelMySuffixDeleteDialogComponent {
    tekstRegel: ITekstRegelMySuffix;

    constructor(
        private tekstRegelService: TekstRegelMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.tekstRegelService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'tekstRegelListModification',
                content: 'Deleted an tekstRegel'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-tekst-regel-my-suffix-delete-popup',
    template: ''
})
export class TekstRegelMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tekstRegel }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TekstRegelMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.tekstRegel = tekstRegel;
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
