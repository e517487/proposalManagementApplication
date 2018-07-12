import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';
import { Principal } from 'app/core';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-my-suffix',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-my-suffix.component.html'
})
export class Record11AanvraagGegevensOpmerkingenMySuffixComponent implements OnInit, OnDestroy {
    record11AanvraagGegevensOpmerkingens: IRecord11AanvraagGegevensOpmerkingenMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record11AanvraagGegevensOpmerkingenService: Record11AanvraagGegevensOpmerkingenMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record11AanvraagGegevensOpmerkingenService.query().subscribe(
            (res: HttpResponse<IRecord11AanvraagGegevensOpmerkingenMySuffix[]>) => {
                this.record11AanvraagGegevensOpmerkingens = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord11AanvraagGegevensOpmerkingens();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord11AanvraagGegevensOpmerkingenMySuffix) {
        return item.id;
    }

    registerChangeInRecord11AanvraagGegevensOpmerkingens() {
        this.eventSubscriber = this.eventManager.subscribe('record11AanvraagGegevensOpmerkingenListModification', response =>
            this.loadAll()
        );
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
