import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord61Uitleg } from 'app/shared/model/record-61-uitleg.model';
import { Record61UitlegService } from './record-61-uitleg.service';

@Component({
    selector: 'jhi-record-61-uitleg-delete-dialog',
    templateUrl: './record-61-uitleg-delete-dialog.component.html'
})
export class Record61UitlegDeleteDialogComponent {
    record61Uitleg: IRecord61Uitleg;

    constructor(
        private record61UitlegService: Record61UitlegService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record61UitlegService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record61UitlegListModification',
                content: 'Deleted an record61Uitleg'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-61-uitleg-delete-popup',
    template: ''
})
export class Record61UitlegDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record61Uitleg }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record61UitlegDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record61Uitleg = record61Uitleg;
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
