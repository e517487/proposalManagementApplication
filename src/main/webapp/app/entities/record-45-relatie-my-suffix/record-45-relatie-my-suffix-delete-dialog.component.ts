import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';
import { Record45RelatieMySuffixService } from './record-45-relatie-my-suffix.service';

@Component({
    selector: 'jhi-record-45-relatie-my-suffix-delete-dialog',
    templateUrl: './record-45-relatie-my-suffix-delete-dialog.component.html'
})
export class Record45RelatieMySuffixDeleteDialogComponent {
    record45Relatie: IRecord45RelatieMySuffix;

    constructor(
        private record45RelatieService: Record45RelatieMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record45RelatieService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record45RelatieListModification',
                content: 'Deleted an record45Relatie'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-45-relatie-my-suffix-delete-popup',
    template: ''
})
export class Record45RelatieMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record45Relatie }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record45RelatieMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record45Relatie = record45Relatie;
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
