import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IKredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';
import { Principal } from 'app/core';
import { KredietAanvraagMySuffixService } from './krediet-aanvraag-my-suffix.service';

@Component({
    selector: 'jhi-krediet-aanvraag-my-suffix',
    templateUrl: './krediet-aanvraag-my-suffix.component.html'
})
export class KredietAanvraagMySuffixComponent implements OnInit, OnDestroy {
    kredietAanvraags: IKredietAanvraagMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private kredietAanvraagService: KredietAanvraagMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.kredietAanvraagService.query().subscribe(
            (res: HttpResponse<IKredietAanvraagMySuffix[]>) => {
                this.kredietAanvraags = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInKredietAanvraags();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IKredietAanvraagMySuffix) {
        return item.id;
    }

    registerChangeInKredietAanvraags() {
        this.eventSubscriber = this.eventManager.subscribe('kredietAanvraagListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
