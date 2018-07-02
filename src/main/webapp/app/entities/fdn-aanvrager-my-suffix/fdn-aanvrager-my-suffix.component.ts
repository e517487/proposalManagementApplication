import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { Principal } from 'app/core';
import { FdnAanvragerMySuffixService } from './fdn-aanvrager-my-suffix.service';

@Component({
    selector: 'jhi-fdn-aanvrager-my-suffix',
    templateUrl: './fdn-aanvrager-my-suffix.component.html'
})
export class FdnAanvragerMySuffixComponent implements OnInit, OnDestroy {
    fdnAanvragers: IFdnAanvragerMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.fdnAanvragerService.query().subscribe(
            (res: HttpResponse<IFdnAanvragerMySuffix[]>) => {
                this.fdnAanvragers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInFdnAanvragers();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IFdnAanvragerMySuffix) {
        return item.id;
    }

    registerChangeInFdnAanvragers() {
        this.eventSubscriber = this.eventManager.subscribe('fdnAanvragerListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
