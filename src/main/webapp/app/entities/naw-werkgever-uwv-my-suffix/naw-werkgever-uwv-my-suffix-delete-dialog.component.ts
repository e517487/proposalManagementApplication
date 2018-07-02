import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { INawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';
import { NawWerkgeverUWVMySuffixService } from './naw-werkgever-uwv-my-suffix.service';

@Component({
    selector: 'jhi-naw-werkgever-uwv-my-suffix-delete-dialog',
    templateUrl: './naw-werkgever-uwv-my-suffix-delete-dialog.component.html'
})
export class NawWerkgeverUWVMySuffixDeleteDialogComponent {
    nawWerkgeverUWV: INawWerkgeverUWVMySuffix;

    constructor(
        private nawWerkgeverUWVService: NawWerkgeverUWVMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.nawWerkgeverUWVService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'nawWerkgeverUWVListModification',
                content: 'Deleted an nawWerkgeverUWV'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-naw-werkgever-uwv-my-suffix-delete-popup',
    template: ''
})
export class NawWerkgeverUWVMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ nawWerkgeverUWV }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(NawWerkgeverUWVMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.nawWerkgeverUWV = nawWerkgeverUWV;
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
