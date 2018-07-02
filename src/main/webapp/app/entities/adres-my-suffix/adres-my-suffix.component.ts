import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IAdresMySuffix } from 'app/shared/model/adres-my-suffix.model';
import { Principal } from 'app/core';
import { AdresMySuffixService } from './adres-my-suffix.service';

@Component({
    selector: 'jhi-adres-my-suffix',
    templateUrl: './adres-my-suffix.component.html'
})
export class AdresMySuffixComponent implements OnInit, OnDestroy {
    adres: IAdresMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private adresService: AdresMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.adresService.query().subscribe(
            (res: HttpResponse<IAdresMySuffix[]>) => {
                this.adres = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInAdres();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IAdresMySuffix) {
        return item.id;
    }

    registerChangeInAdres() {
        this.eventSubscriber = this.eventManager.subscribe('adresListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
