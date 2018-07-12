import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';
import { Record62UitlegMySuffixService } from './record-62-uitleg-my-suffix.service';

@Component({
    selector: 'jhi-record-62-uitleg-my-suffix-delete-dialog',
    templateUrl: './record-62-uitleg-my-suffix-delete-dialog.component.html'
})
export class Record62UitlegMySuffixDeleteDialogComponent {
    record62Uitleg: IRecord62UitlegMySuffix;

    constructor(
        private record62UitlegService: Record62UitlegMySuffixService,
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
    selector: 'jhi-record-62-uitleg-my-suffix-delete-popup',
    template: ''
})
export class Record62UitlegMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record62Uitleg }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record62UitlegMySuffixDeleteDialogComponent as Component, {
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
