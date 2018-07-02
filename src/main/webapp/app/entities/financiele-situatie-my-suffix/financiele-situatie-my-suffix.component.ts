import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IFinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';
import { Principal } from 'app/core';
import { FinancieleSituatieMySuffixService } from './financiele-situatie-my-suffix.service';

@Component({
    selector: 'jhi-financiele-situatie-my-suffix',
    templateUrl: './financiele-situatie-my-suffix.component.html'
})
export class FinancieleSituatieMySuffixComponent implements OnInit, OnDestroy {
    financieleSituaties: IFinancieleSituatieMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private financieleSituatieService: FinancieleSituatieMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.financieleSituatieService.query().subscribe(
            (res: HttpResponse<IFinancieleSituatieMySuffix[]>) => {
                this.financieleSituaties = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInFinancieleSituaties();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IFinancieleSituatieMySuffix) {
        return item.id;
    }

    registerChangeInFinancieleSituaties() {
        this.eventSubscriber = this.eventManager.subscribe('financieleSituatieListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
