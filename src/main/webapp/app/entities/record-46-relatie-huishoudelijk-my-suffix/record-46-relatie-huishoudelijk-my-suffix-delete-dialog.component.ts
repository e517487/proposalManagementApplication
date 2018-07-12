import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';
import { Record46RelatieHuishoudelijkMySuffixService } from './record-46-relatie-huishoudelijk-my-suffix.service';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-my-suffix-delete-dialog',
    templateUrl: './record-46-relatie-huishoudelijk-my-suffix-delete-dialog.component.html'
})
export class Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent {
    record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijkMySuffix;

    constructor(
        private record46RelatieHuishoudelijkService: Record46RelatieHuishoudelijkMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.record46RelatieHuishoudelijkService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'record46RelatieHuishoudelijkListModification',
                content: 'Deleted an record46RelatieHuishoudelijk'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-my-suffix-delete-popup',
    template: ''
})
export class Record46RelatieHuishoudelijkMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record46RelatieHuishoudelijk }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.record46RelatieHuishoudelijk = record46RelatieHuishoudelijk;
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
