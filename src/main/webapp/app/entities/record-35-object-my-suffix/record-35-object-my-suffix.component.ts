import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';
import { Principal } from 'app/core';
import { Record35ObjectMySuffixService } from './record-35-object-my-suffix.service';

@Component({
    selector: 'jhi-record-35-object-my-suffix',
    templateUrl: './record-35-object-my-suffix.component.html'
})
export class Record35ObjectMySuffixComponent implements OnInit, OnDestroy {
    record35Objects: IRecord35ObjectMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record35ObjectService: Record35ObjectMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record35ObjectService.query().subscribe(
            (res: HttpResponse<IRecord35ObjectMySuffix[]>) => {
                this.record35Objects = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord35Objects();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord35ObjectMySuffix) {
        return item.id;
    }

    registerChangeInRecord35Objects() {
        this.eventSubscriber = this.eventManager.subscribe('record35ObjectListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
