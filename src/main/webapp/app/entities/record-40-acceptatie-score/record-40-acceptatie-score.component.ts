import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';
import { Principal } from 'app/core';
import { Record40AcceptatieScoreService } from './record-40-acceptatie-score.service';

@Component({
    selector: 'jhi-record-40-acceptatie-score',
    templateUrl: './record-40-acceptatie-score.component.html'
})
export class Record40AcceptatieScoreComponent implements OnInit, OnDestroy {
    record40AcceptatieScores: IRecord40AcceptatieScore[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record40AcceptatieScoreService: Record40AcceptatieScoreService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record40AcceptatieScoreService.query().subscribe(
            (res: HttpResponse<IRecord40AcceptatieScore[]>) => {
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

    trackId(index: number, item: IRecord40AcceptatieScore) {
        return item.id;
    }

    registerChangeInRecord40AcceptatieScores() {
        this.eventSubscriber = this.eventManager.subscribe('record40AcceptatieScoreListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
