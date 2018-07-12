import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';
import { Principal } from 'app/core';
import { Record40AcceptatieScoreMySuffixService } from './record-40-acceptatie-score-my-suffix.service';

@Component({
    selector: 'jhi-record-40-acceptatie-score-my-suffix',
    templateUrl: './record-40-acceptatie-score-my-suffix.component.html'
})
export class Record40AcceptatieScoreMySuffixComponent implements OnInit, OnDestroy {
    record40AcceptatieScores: IRecord40AcceptatieScoreMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record40AcceptatieScoreService: Record40AcceptatieScoreMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record40AcceptatieScoreService.query().subscribe(
            (res: HttpResponse<IRecord40AcceptatieScoreMySuffix[]>) => {
                this.record40AcceptatieScores = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord40AcceptatieScores();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord40AcceptatieScoreMySuffix) {
        return item.id;
    }

    registerChangeInRecord40AcceptatieScores() {
        this.eventSubscriber = this.eventManager.subscribe('record40AcceptatieScoreListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
