import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord55Scoring } from 'app/shared/model/record-55-scoring.model';
import { Principal } from 'app/core';
import { Record55ScoringService } from './record-55-scoring.service';

@Component({
    selector: 'jhi-record-55-scoring',
    templateUrl: './record-55-scoring.component.html'
})
export class Record55ScoringComponent implements OnInit, OnDestroy {
    record55Scorings: IRecord55Scoring[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record55ScoringService: Record55ScoringService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record55ScoringService.query().subscribe(
            (res: HttpResponse<IRecord55Scoring[]>) => {
                this.record55Scorings = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord55Scorings();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord55Scoring) {
        return item.id;
    }

    registerChangeInRecord55Scorings() {
        this.eventSubscriber = this.eventManager.subscribe('record55ScoringListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
