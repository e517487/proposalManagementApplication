import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';
import { Principal } from 'app/core';
import { Record25HerfinancieeringService } from './record-25-herfinancieering.service';

@Component({
    selector: 'jhi-record-25-herfinancieering',
    templateUrl: './record-25-herfinancieering.component.html'
})
export class Record25HerfinancieeringComponent implements OnInit, OnDestroy {
    record25Herfinancieerings: IRecord25Herfinancieering[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record25HerfinancieeringService: Record25HerfinancieeringService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record25HerfinancieeringService.query().subscribe(
            (res: HttpResponse<IRecord25Herfinancieering[]>) => {
                this.record25Herfinancieerings = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord25Herfinancieerings();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord25Herfinancieering) {
        return item.id;
    }

    registerChangeInRecord25Herfinancieerings() {
        this.eventSubscriber = this.eventManager.subscribe('record25HerfinancieeringListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
