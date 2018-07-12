import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';
import { Principal } from 'app/core';
import { Record99EindMySuffixService } from './record-99-eind-my-suffix.service';

@Component({
    selector: 'jhi-record-99-eind-my-suffix',
    templateUrl: './record-99-eind-my-suffix.component.html'
})
export class Record99EindMySuffixComponent implements OnInit, OnDestroy {
    record99Einds: IRecord99EindMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record99EindService: Record99EindMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record99EindService.query().subscribe(
            (res: HttpResponse<IRecord99EindMySuffix[]>) => {
                this.record99Einds = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord99Einds();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord99EindMySuffix) {
        return item.id;
    }

    registerChangeInRecord99Einds() {
        this.eventSubscriber = this.eventManager.subscribe('record99EindListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
