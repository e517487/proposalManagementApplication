import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';
import { Principal } from 'app/core';
import { Record10AanvraagGegevensAlgemeenService } from './record-10-aanvraag-gegevens-algemeen.service';

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen',
    templateUrl: './record-10-aanvraag-gegevens-algemeen.component.html'
})
export class Record10AanvraagGegevensAlgemeenComponent implements OnInit, OnDestroy {
    record10AanvraagGegevensAlgemeens: IRecord10AanvraagGegevensAlgemeen[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record10AanvraagGegevensAlgemeenService: Record10AanvraagGegevensAlgemeenService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record10AanvraagGegevensAlgemeenService.query().subscribe(
            (res: HttpResponse<IRecord10AanvraagGegevensAlgemeen[]>) => {
                this.record10AanvraagGegevensAlgemeens = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord10AanvraagGegevensAlgemeens();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord10AanvraagGegevensAlgemeen) {
        return item.id;
    }

    registerChangeInRecord10AanvraagGegevensAlgemeens() {
        this.eventSubscriber = this.eventManager.subscribe('record10AanvraagGegevensAlgemeenListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
