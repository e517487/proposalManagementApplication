import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IRecord46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';
import { Record46RelatieHuishoudelijkService } from './record-46-relatie-huishoudelijk.service';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-delete-dialog',
    templateUrl: './record-46-relatie-huishoudelijk-delete-dialog.component.html'
})
export class Record46RelatieHuishoudelijkDeleteDialogComponent {
    record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijk;

    constructor(
        private record46RelatieHuishoudelijkService: Record46RelatieHuishoudelijkService,
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
    selector: 'jhi-record-46-relatie-huishoudelijk-delete-popup',
    template: ''
})
export class Record46RelatieHuishoudelijkDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record46RelatieHuishoudelijk }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(Record46RelatieHuishoudelijkDeleteDialogComponent as Component, {
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
