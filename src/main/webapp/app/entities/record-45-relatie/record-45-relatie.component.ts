import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRecord45Relatie } from 'app/shared/model/record-45-relatie.model';
import { Principal } from 'app/core';
import { Record45RelatieService } from './record-45-relatie.service';

@Component({
    selector: 'jhi-record-45-relatie',
    templateUrl: './record-45-relatie.component.html'
})
export class Record45RelatieComponent implements OnInit, OnDestroy {
    record45Relaties: IRecord45Relatie[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private record45RelatieService: Record45RelatieService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.record45RelatieService.query().subscribe(
            (res: HttpResponse<IRecord45Relatie[]>) => {
                this.record45Relaties = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRecord45Relaties();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRecord45Relatie) {
        return item.id;
    }

    registerChangeInRecord45Relaties() {
        this.eventSubscriber = this.eventManager.subscribe('record45RelatieListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
