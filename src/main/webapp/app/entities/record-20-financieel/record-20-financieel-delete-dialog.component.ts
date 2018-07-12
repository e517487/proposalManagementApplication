import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord20Financieel } from 'app/shared/model/record-20-financieel.model';
import { Record20FinancieelService } from './record-20-financieel.service';

@Component({
    selector: 'jhi-record-20-financieel-delete-dialog',
    templateUrl: './record-20-financieel-delete-dialog.component.html'
})
export class Record20FinancieelDeleteDialogComponent {
    record20Financieel: IRecord20Financieel;

    constructor(
        private record20FinancieelService: Record20FinancieelService,
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
    selector: 'jhi-record-20-financieel-delete-popup',
    template: ''
})
export class Record20FinancieelDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record20Financieel }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record20FinancieelDeleteDialogComponent as Component, {
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
