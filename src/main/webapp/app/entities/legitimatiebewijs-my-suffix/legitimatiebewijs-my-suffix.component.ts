import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ILegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';
import { Principal } from 'app/core';
import { LegitimatiebewijsMySuffixService } from './legitimatiebewijs-my-suffix.service';

@Component({
    selector: 'jhi-legitimatiebewijs-my-suffix',
    templateUrl: './legitimatiebewijs-my-suffix.component.html'
})
export class LegitimatiebewijsMySuffixComponent implements OnInit, OnDestroy {
    legitimatiebewijs: ILegitimatiebewijsMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private legitimatiebewijsService: LegitimatiebewijsMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.legitimatiebewijsService.query().subscribe(
            (res: HttpResponse<ILegitimatiebewijsMySuffix[]>) => {
                this.legitimatiebewijs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInLegitimatiebewijs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ILegitimatiebewijsMySuffix) {
        return item.id;
    }

    registerChangeInLegitimatiebewijs() {
        this.eventSubscriber = this.eventManager.subscribe('legitimatiebewijsListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
