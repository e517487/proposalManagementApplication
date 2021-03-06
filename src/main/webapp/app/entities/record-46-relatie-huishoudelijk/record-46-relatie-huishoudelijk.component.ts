import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';
import { Principal } from 'app/core';
import { Record46RelatieHuishoudelijkService } from './record-46-relatie-huishoudelijk.service';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk',
    templateUrl: './record-46-relatie-huishoudelijk.component.html'
})
export class Record46RelatieHuishoudelijkComponent implements OnInit, OnDestroy {
    record46RelatieHuishoudelijks: IRecord46RelatieHuishoudelijk[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record46RelatieHuishoudelijkService: Record46RelatieHuishoudelijkService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record46RelatieHuishoudelijkService.query().subscribe(
            (res: HttpResponse<IRecord46RelatieHuishoudelijk[]>) => {
                this.record46RelatieHuishoudelijks = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord46RelatieHuishoudelijks();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord46RelatieHuishoudelijk) {
        return item.id;
    }

    registerChangeInRecord46RelatieHuishoudelijks() {
        this.eventSubscriber = this.eventManager.subscribe('record46RelatieHuishoudelijkListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
