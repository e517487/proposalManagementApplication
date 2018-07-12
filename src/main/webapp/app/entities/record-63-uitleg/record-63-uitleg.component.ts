import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord63Uitleg } from 'app/shared/model/record-63-uitleg.model';
import { Principal } from 'app/core';
import { Record63UitlegService } from './record-63-uitleg.service';

@Component({
    selector: 'jhi-record-63-uitleg',
    templateUrl: './record-63-uitleg.component.html'
})
export class Record63UitlegComponent implements OnInit, OnDestroy {
    record63Uitlegs: IRecord63Uitleg[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record63UitlegService: Record63UitlegService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record63UitlegService.query().subscribe(
            (res: HttpResponse<IRecord63Uitleg[]>) => {
                this.record63Uitlegs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord63Uitlegs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord63Uitleg) {
        return item.id;
    }

    registerChangeInRecord63Uitlegs() {
        this.eventSubscriber = this.eventManager.subscribe('record63UitlegListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
