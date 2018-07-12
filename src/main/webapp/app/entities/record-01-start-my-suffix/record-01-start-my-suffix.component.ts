import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';
import { Principal } from 'app/core';
import { Record01StartMySuffixService } from './record-01-start-my-suffix.service';

@Component({
    selector: 'jhi-record-01-start-my-suffix',
    templateUrl: './record-01-start-my-suffix.component.html'
})
export class Record01StartMySuffixComponent implements OnInit, OnDestroy {
    record01Starts: IRecord01StartMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record01StartService: Record01StartMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record01StartService.query().subscribe(
            (res: HttpResponse<IRecord01StartMySuffix[]>) => {
                this.record01Starts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord01Starts();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord01StartMySuffix) {
        return item.id;
    }

    registerChangeInRecord01Starts() {
        this.eventSubscriber = this.eventManager.subscribe('record01StartListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
