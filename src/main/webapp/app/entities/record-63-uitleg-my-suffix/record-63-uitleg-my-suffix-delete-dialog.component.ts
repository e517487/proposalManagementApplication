import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';
import { Record63UitlegMySuffixService } from './record-63-uitleg-my-suffix.service';

@Component({
    selector: 'jhi-record-63-uitleg-my-suffix-delete-dialog',
    templateUrl: './record-63-uitleg-my-suffix-delete-dialog.component.html'
})
export class Record63UitlegMySuffixDeleteDialogComponent {
    record63Uitleg: IRecord63UitlegMySuffix;

    constructor(
        private record63UitlegService: Record63UitlegMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record63UitlegService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record63UitlegListModification',
                content: 'Deleted an record63Uitleg'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-63-uitleg-my-suffix-delete-popup',
    template: ''
})
export class Record63UitlegMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record63Uitleg }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record63UitlegMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record63Uitleg = record63Uitleg;
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
