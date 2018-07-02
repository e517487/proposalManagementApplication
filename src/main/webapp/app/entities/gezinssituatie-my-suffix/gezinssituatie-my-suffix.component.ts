import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IGezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';
import { Principal } from 'app/core';
import { GezinssituatieMySuffixService } from './gezinssituatie-my-suffix.service';

@Component({
    selector: 'jhi-gezinssituatie-my-suffix',
    templateUrl: './gezinssituatie-my-suffix.component.html'
})
export class GezinssituatieMySuffixComponent implements OnInit, OnDestroy {
    gezinssituaties: IGezinssituatieMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private gezinssituatieService: GezinssituatieMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.gezinssituatieService.query().subscribe(
            (res: HttpResponse<IGezinssituatieMySuffix[]>) => {
                this.gezinssituaties = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInGezinssituaties();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IGezinssituatieMySuffix) {
        return item.id;
    }

    registerChangeInGezinssituaties() {
        this.eventSubscriber = this.eventManager.subscribe('gezinssituatieListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
