import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';
import { Principal } from 'app/core';
import { Record61UitlegMySuffixService } from './record-61-uitleg-my-suffix.service';

@Component({
    selector: 'jhi-record-61-uitleg-my-suffix',
    templateUrl: './record-61-uitleg-my-suffix.component.html'
})
export class Record61UitlegMySuffixComponent implements OnInit, OnDestroy {
    record61Uitlegs: IRecord61UitlegMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record61UitlegService: Record61UitlegMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record61UitlegService.query().subscribe(
            (res: HttpResponse<IRecord61UitlegMySuffix[]>) => {
                this.record61Uitlegs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord61Uitlegs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord61UitlegMySuffix) {
        return item.id;
    }

    registerChangeInRecord61Uitlegs() {
        this.eventSubscriber = this.eventManager.subscribe('record61UitlegListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
