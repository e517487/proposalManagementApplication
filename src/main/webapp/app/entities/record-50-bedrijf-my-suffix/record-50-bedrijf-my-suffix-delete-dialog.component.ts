import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';
import { Record50BedrijfMySuffixService } from './record-50-bedrijf-my-suffix.service';

@Component({
    selector: 'jhi-record-50-bedrijf-my-suffix-delete-dialog',
    templateUrl: './record-50-bedrijf-my-suffix-delete-dialog.component.html'
})
export class Record50BedrijfMySuffixDeleteDialogComponent {
    record50Bedrijf: IRecord50BedrijfMySuffix;

    constructor(
        private record50BedrijfService: Record50BedrijfMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record50BedrijfService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record50BedrijfListModification',
                content: 'Deleted an record50Bedrijf'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-50-bedrijf-my-suffix-delete-popup',
    template: ''
})
export class Record50BedrijfMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record50Bedrijf }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record50BedrijfMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record50Bedrijf = record50Bedrijf;
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
