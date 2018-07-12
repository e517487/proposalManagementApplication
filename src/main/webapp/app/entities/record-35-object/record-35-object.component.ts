import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord35Object } from 'app/shared/model/record-35-object.model';
import { Principal } from 'app/core';
import { Record35ObjectService } from './record-35-object.service';

@Component({
    selector: 'jhi-record-35-object',
    templateUrl: './record-35-object.component.html'
})
export class Record35ObjectComponent implements OnInit, OnDestroy {
    record35Objects: IRecord35Object[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record35ObjectService: Record35ObjectService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record35ObjectService.query().subscribe(
            (res: HttpResponse<IRecord35Object[]>) => {
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

    trackId(index: number, item: IRecord35Object) {
        return item.id;
    }

    registerChangeInRecord35Objects() {
        this.eventSubscriber = this.eventManager.subscribe('record35ObjectListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
