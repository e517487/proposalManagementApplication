import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';
import { Principal } from 'app/core';
import { Record20FinancieelMySuffixService } from './record-20-financieel-my-suffix.service';

@Component({
    selector: 'jhi-record-20-financieel-my-suffix',
    templateUrl: './record-20-financieel-my-suffix.component.html'
})
export class Record20FinancieelMySuffixComponent implements OnInit, OnDestroy {
    record20Financieels: IRecord20FinancieelMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record20FinancieelService: Record20FinancieelMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record20FinancieelService.query().subscribe(
            (res: HttpResponse<IRecord20FinancieelMySuffix[]>) => {
                this.record20Financieels = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord20Financieels();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord20FinancieelMySuffix) {
        return item.id;
    }

    registerChangeInRecord20Financieels() {
        this.eventSubscriber = this.eventManager.subscribe('record20FinancieelListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
