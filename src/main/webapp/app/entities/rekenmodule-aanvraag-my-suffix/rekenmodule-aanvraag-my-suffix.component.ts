import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';
import { Principal } from 'app/core';
import { RekenmoduleAanvraagMySuffixService } from './rekenmodule-aanvraag-my-suffix.service';

@Component({
    selector: 'jhi-rekenmodule-aanvraag-my-suffix',
    templateUrl: './rekenmodule-aanvraag-my-suffix.component.html'
})
export class RekenmoduleAanvraagMySuffixComponent implements OnInit, OnDestroy {
    rekenmoduleAanvraags: IRekenmoduleAanvraagMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private rekenmoduleAanvraagService: RekenmoduleAanvraagMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.rekenmoduleAanvraagService.query().subscribe(
            (res: HttpResponse<IRekenmoduleAanvraagMySuffix[]>) => {
                this.rekenmoduleAanvraags = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInRekenmoduleAanvraags();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IRekenmoduleAanvraagMySuffix) {
        return item.id;
    }

    registerChangeInRekenmoduleAanvraags() {
        this.eventSubscriber = this.eventManager.subscribe('rekenmoduleAanvraagListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
