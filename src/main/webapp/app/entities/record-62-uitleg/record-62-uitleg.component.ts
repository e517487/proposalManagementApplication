import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord62Uitleg } from 'app/shared/model/record-62-uitleg.model';
import { Principal } from 'app/core';
import { Record62UitlegService } from './record-62-uitleg.service';

@Component({
    selector: 'jhi-record-62-uitleg',
    templateUrl: './record-62-uitleg.component.html'
})
export class Record62UitlegComponent implements OnInit, OnDestroy {
    record62Uitlegs: IRecord62Uitleg[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record62UitlegService: Record62UitlegService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record62UitlegService.query().subscribe(
            (res: HttpResponse<IRecord62Uitleg[]>) => {
                this.record62Uitlegs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord62Uitlegs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord62Uitleg) {
        return item.id;
    }

    registerChangeInRecord62Uitlegs() {
        this.eventSubscriber = this.eventManager.subscribe('record62UitlegListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
