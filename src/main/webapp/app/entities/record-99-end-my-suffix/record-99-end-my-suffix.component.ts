import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';
import { Principal } from 'app/core';
import { Record99EndMySuffixService } from './record-99-end-my-suffix.service';

@Component({
    selector: 'jhi-record-99-end-my-suffix',
    templateUrl: './record-99-end-my-suffix.component.html'
})
export class Record99EndMySuffixComponent implements OnInit, OnDestroy {
    record99Ends: IRecord99EndMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record99EndService: Record99EndMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record99EndService.query().subscribe(
            (res: HttpResponse<IRecord99EndMySuffix[]>) => {
                this.record99Ends = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord99Ends();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord99EndMySuffix) {
        return item.id;
    }

    registerChangeInRecord99Ends() {
        this.eventSubscriber = this.eventManager.subscribe('record99EndListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
