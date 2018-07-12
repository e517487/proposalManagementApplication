import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';
import { Record20FinancieelMySuffixService } from './record-20-financieel-my-suffix.service';

@Component({
    selector: 'jhi-record-20-financieel-my-suffix-delete-dialog',
    templateUrl: './record-20-financieel-my-suffix-delete-dialog.component.html'
})
export class Record20FinancieelMySuffixDeleteDialogComponent {
    record20Financieel: IRecord20FinancieelMySuffix;

    constructor(
        private record20FinancieelService: Record20FinancieelMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record20FinancieelService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record20FinancieelListModification',
                content: 'Deleted an record20Financieel'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-20-financieel-my-suffix-delete-popup',
    template: ''
})
export class Record20FinancieelMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record20Financieel }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record20FinancieelMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record20Financieel = record20Financieel;
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
