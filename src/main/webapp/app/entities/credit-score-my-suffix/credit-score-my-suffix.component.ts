import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ICreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';
import { Principal } from 'app/core';
import { CreditScoreMySuffixService } from './credit-score-my-suffix.service';

@Component({
    selector: 'jhi-credit-score-my-suffix',
    templateUrl: './credit-score-my-suffix.component.html'
})
export class CreditScoreMySuffixComponent implements OnInit, OnDestroy {
    creditScores: ICreditScoreMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private creditScoreService: CreditScoreMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.creditScoreService.query().subscribe(
            (res: HttpResponse<ICreditScoreMySuffix[]>) => {
                this.creditScores = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInCreditScores();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ICreditScoreMySuffix) {
        return item.id;
    }

    registerChangeInCreditScores() {
        this.eventSubscriber = this.eventManager.subscribe('creditScoreListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
