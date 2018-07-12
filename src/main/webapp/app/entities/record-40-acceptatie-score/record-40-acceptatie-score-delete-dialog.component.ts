import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';
import { Record40AcceptatieScoreService } from './record-40-acceptatie-score.service';

@Component({
    selector: 'jhi-record-40-acceptatie-score-delete-dialog',
    templateUrl: './record-40-acceptatie-score-delete-dialog.component.html'
})
export class Record40AcceptatieScoreDeleteDialogComponent {
    record40AcceptatieScore: IRecord40AcceptatieScore;

    constructor(
        private record40AcceptatieScoreService: Record40AcceptatieScoreService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record40AcceptatieScoreService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record40AcceptatieScoreListModification',
                content: 'Deleted an record40AcceptatieScore'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-40-acceptatie-score-delete-popup',
    template: ''
})
export class Record40AcceptatieScoreDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record40AcceptatieScore }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record40AcceptatieScoreDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record40AcceptatieScore = record40AcceptatieScore;
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
