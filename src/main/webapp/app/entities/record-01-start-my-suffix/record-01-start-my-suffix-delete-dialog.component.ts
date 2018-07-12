import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';
import { Record01StartMySuffixService } from './record-01-start-my-suffix.service';

@Component({
    selector: 'jhi-record-01-start-my-suffix-delete-dialog',
    templateUrl: './record-01-start-my-suffix-delete-dialog.component.html'
})
export class Record01StartMySuffixDeleteDialogComponent {
    record01Start: IRecord01StartMySuffix;

    constructor(
        private record01StartService: Record01StartMySuffixService,
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
    selector: 'jhi-record-01-start-my-suffix-delete-popup',
    template: ''
})
export class Record01StartMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record01Start }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record01StartMySuffixDeleteDialogComponent as Component, {
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
