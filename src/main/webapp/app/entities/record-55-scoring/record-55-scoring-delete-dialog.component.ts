import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord55Scoring } from 'app/shared/model/record-55-scoring.model';
import { Record55ScoringService } from './record-55-scoring.service';

@Component({
    selector: 'jhi-record-55-scoring-delete-dialog',
    templateUrl: './record-55-scoring-delete-dialog.component.html'
})
export class Record55ScoringDeleteDialogComponent {
    record55Scoring: IRecord55Scoring;

    constructor(
        private record55ScoringService: Record55ScoringService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record55ScoringService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record55ScoringListModification',
                content: 'Deleted an record55Scoring'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-55-scoring-delete-popup',
    template: ''
})
export class Record55ScoringDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record55Scoring }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record55ScoringDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record55Scoring = record55Scoring;
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
