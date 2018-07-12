import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord62Uitleg } from 'app/shared/model/record-62-uitleg.model';
import { Record62UitlegService } from './record-62-uitleg.service';

@Component({
    selector: 'jhi-record-62-uitleg-delete-dialog',
    templateUrl: './record-62-uitleg-delete-dialog.component.html'
})
export class Record62UitlegDeleteDialogComponent {
    record62Uitleg: IRecord62Uitleg;

    constructor(
        private record62UitlegService: Record62UitlegService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record62UitlegService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record62UitlegListModification',
                content: 'Deleted an record62Uitleg'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-62-uitleg-delete-popup',
    template: ''
})
export class Record62UitlegDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record62Uitleg }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record62UitlegDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record62Uitleg = record62Uitleg;
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
