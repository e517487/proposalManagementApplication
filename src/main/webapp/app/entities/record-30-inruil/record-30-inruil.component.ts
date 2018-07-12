import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord30Inruil } from 'app/shared/model/record-30-inruil.model';
import { Principal } from 'app/core';
import { Record30InruilService } from './record-30-inruil.service';

@Component({
    selector: 'jhi-record-30-inruil',
    templateUrl: './record-30-inruil.component.html'
})
export class Record30InruilComponent implements OnInit, OnDestroy {
    record30Inruils: IRecord30Inruil[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record30InruilService: Record30InruilService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record30InruilService.query().subscribe(
            (res: HttpResponse<IRecord30Inruil[]>) => {
                this.record30Inruils = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord30Inruils();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord30Inruil) {
        return item.id;
    }

    registerChangeInRecord30Inruils() {
        this.eventSubscriber = this.eventManager.subscribe('record30InruilListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
