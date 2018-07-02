import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IKredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';
import { KredietAanvraagMySuffixService } from './krediet-aanvraag-my-suffix.service';

@Component({
    selector: 'jhi-krediet-aanvraag-my-suffix-delete-dialog',
    templateUrl: './krediet-aanvraag-my-suffix-delete-dialog.component.html'
})
export class KredietAanvraagMySuffixDeleteDialogComponent {
    kredietAanvraag: IKredietAanvraagMySuffix;

    constructor(
        private kredietAanvraagService: KredietAanvraagMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.kredietAanvraagService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'kredietAanvraagListModification',
                content: 'Deleted an kredietAanvraag'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-krediet-aanvraag-my-suffix-delete-popup',
    template: ''
})
export class KredietAanvraagMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ kredietAanvraag }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(KredietAanvraagMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.kredietAanvraag = kredietAanvraag;
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
