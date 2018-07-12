import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord01Start } from 'app/shared/model/record-01-start.model';
import { Record01StartService } from './record-01-start.service';

@Component({
    selector: 'jhi-record-01-start-delete-dialog',
    templateUrl: './record-01-start-delete-dialog.component.html'
})
export class Record01StartDeleteDialogComponent {
    record01Start: IRecord01Start;

    constructor(
        private record01StartService: Record01StartService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record01StartService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record01StartListModification',
                content: 'Deleted an record01Start'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-01-start-delete-popup',
    template: ''
})
export class Record01StartDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record01Start }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record01StartDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record01Start = record01Start;
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
