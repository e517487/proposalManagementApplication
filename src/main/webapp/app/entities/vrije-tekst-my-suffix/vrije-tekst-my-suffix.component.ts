import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';
import { Principal } from 'app/core';
import { VrijeTekstMySuffixService } from './vrije-tekst-my-suffix.service';

@Component({
    selector: 'jhi-vrije-tekst-my-suffix',
    templateUrl: './vrije-tekst-my-suffix.component.html'
})
export class VrijeTekstMySuffixComponent implements OnInit, OnDestroy {
    vrijeTeksts: IVrijeTekstMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private vrijeTekstService: VrijeTekstMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.vrijeTekstService.query().subscribe(
            (res: HttpResponse<IVrijeTekstMySuffix[]>) => {
                this.vrijeTeksts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInVrijeTeksts();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IVrijeTekstMySuffix) {
        return item.id;
    }

    registerChangeInVrijeTeksts() {
        this.eventSubscriber = this.eventManager.subscribe('vrijeTekstListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
