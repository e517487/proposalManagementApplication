import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';
import { HeaderMySuffixService } from './header-my-suffix.service';

@Component({
    selector: 'jhi-header-my-suffix-delete-dialog',
    templateUrl: './header-my-suffix-delete-dialog.component.html'
})
export class HeaderMySuffixDeleteDialogComponent {
    header: IHeaderMySuffix;

    constructor(private headerService: HeaderMySuffixService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.headerService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'headerListModification',
                content: 'Deleted an header'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-header-my-suffix-delete-popup',
    template: ''
})
export class HeaderMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ header }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(HeaderMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.header = header;
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
