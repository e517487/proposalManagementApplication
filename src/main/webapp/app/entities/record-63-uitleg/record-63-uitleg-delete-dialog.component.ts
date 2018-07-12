import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord63Uitleg } from 'app/shared/model/record-63-uitleg.model';
import { Record63UitlegService } from './record-63-uitleg.service';

@Component({
    selector: 'jhi-record-63-uitleg-delete-dialog',
    templateUrl: './record-63-uitleg-delete-dialog.component.html'
})
export class Record63UitlegDeleteDialogComponent {
    record63Uitleg: IRecord63Uitleg;

    constructor(
        private record63UitlegService: Record63UitlegService,
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
    selector: 'jhi-record-63-uitleg-delete-popup',
    template: ''
})
export class Record63UitlegDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record63Uitleg }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record63UitlegDeleteDialogComponent as Component, {
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
