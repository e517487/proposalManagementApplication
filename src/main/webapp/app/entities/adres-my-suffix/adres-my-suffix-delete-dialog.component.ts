import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IAdresMySuffix } from 'app/shared/model/adres-my-suffix.model';
import { AdresMySuffixService } from './adres-my-suffix.service';

@Component({
    selector: 'jhi-adres-my-suffix-delete-dialog',
    templateUrl: './adres-my-suffix-delete-dialog.component.html'
})
export class AdresMySuffixDeleteDialogComponent {
    adres: IAdresMySuffix;

    constructor(private adresService: AdresMySuffixService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.adresService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'adresListModification',
                content: 'Deleted an adres'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-adres-my-suffix-delete-popup',
    template: ''
})
export class AdresMySuffixDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ adres }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(AdresMySuffixDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.adres = adres;
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
