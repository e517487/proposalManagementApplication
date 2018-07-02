import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';
import { Principal } from 'app/core';
import { HeaderMySuffixService } from './header-my-suffix.service';

@Component({
    selector: 'jhi-header-my-suffix',
    templateUrl: './header-my-suffix.component.html'
})
export class HeaderMySuffixComponent implements OnInit, OnDestroy {
    headers: IHeaderMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private headerService: HeaderMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.headerService.query().subscribe(
            (res: HttpResponse<IHeaderMySuffix[]>) => {
                this.headers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInHeaders();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IHeaderMySuffix) {
        return item.id;
    }

    registerChangeInHeaders() {
        this.eventSubscriber = this.eventManager.subscribe('headerListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
