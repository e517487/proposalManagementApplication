import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { Principal } from 'app/core';
import { AanvraagberichtMySuffixService } from './aanvraagbericht-my-suffix.service';

@Component({
    selector: 'jhi-aanvraagbericht-my-suffix',
    templateUrl: './aanvraagbericht-my-suffix.component.html'
})
export class AanvraagberichtMySuffixComponent implements OnInit, OnDestroy {
    aanvraagberichts: IAanvraagberichtMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.aanvraagberichtService.query().subscribe(
            (res: HttpResponse<IAanvraagberichtMySuffix[]>) => {
                this.aanvraagberichts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInAanvraagberichts();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IAanvraagberichtMySuffix) {
        return item.id;
    }

    registerChangeInAanvraagberichts() {
        this.eventSubscriber = this.eventManager.subscribe('aanvraagberichtListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
