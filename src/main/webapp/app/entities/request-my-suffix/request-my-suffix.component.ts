import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';
import { Principal } from 'app/core';
import { RequestMySuffixService } from './request-my-suffix.service';

@Component({
    selector: 'jhi-request-my-suffix',
    templateUrl: './request-my-suffix.component.html'
})
export class RequestMySuffixComponent implements OnInit, OnDestroy {
    requests: IRequestMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private requestService: RequestMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.requestService.query().subscribe(
            (res: HttpResponse<IRequestMySuffix[]>) => {
                this.requests = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRequests();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRequestMySuffix) {
        return item.id;
    }

    registerChangeInRequests() {
        this.eventSubscriber = this.eventManager.subscribe('requestListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
