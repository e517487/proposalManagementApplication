import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';
import { Principal } from 'app/core';
import { WerksituatieMySuffixService } from './werksituatie-my-suffix.service';

@Component({
    selector: 'jhi-werksituatie-my-suffix',
    templateUrl: './werksituatie-my-suffix.component.html'
})
export class WerksituatieMySuffixComponent implements OnInit, OnDestroy {
    werksituaties: IWerksituatieMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private werksituatieService: WerksituatieMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.werksituatieService.query().subscribe(
            (res: HttpResponse<IWerksituatieMySuffix[]>) => {
                this.werksituaties = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInWerksituaties();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IWerksituatieMySuffix) {
        return item.id;
    }

    registerChangeInWerksituaties() {
        this.eventSubscriber = this.eventManager.subscribe('werksituatieListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
