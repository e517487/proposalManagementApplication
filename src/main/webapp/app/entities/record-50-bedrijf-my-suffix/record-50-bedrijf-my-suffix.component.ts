import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';
import { Principal } from 'app/core';
import { Record50BedrijfMySuffixService } from './record-50-bedrijf-my-suffix.service';

@Component({
    selector: 'jhi-record-50-bedrijf-my-suffix',
    templateUrl: './record-50-bedrijf-my-suffix.component.html'
})
export class Record50BedrijfMySuffixComponent implements OnInit, OnDestroy {
    record50Bedrijfs: IRecord50BedrijfMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record50BedrijfService: Record50BedrijfMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record50BedrijfService.query().subscribe(
            (res: HttpResponse<IRecord50BedrijfMySuffix[]>) => {
                this.record50Bedrijfs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord50Bedrijfs();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord50BedrijfMySuffix) {
        return item.id;
    }

    registerChangeInRecord50Bedrijfs() {
        this.eventSubscriber = this.eventManager.subscribe('record50BedrijfListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
