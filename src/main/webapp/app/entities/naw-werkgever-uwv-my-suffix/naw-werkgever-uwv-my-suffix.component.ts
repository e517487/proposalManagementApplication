import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { INawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';
import { Principal } from 'app/core';
import { NawWerkgeverUWVMySuffixService } from './naw-werkgever-uwv-my-suffix.service';

@Component({
    selector: 'jhi-naw-werkgever-uwv-my-suffix',
    templateUrl: './naw-werkgever-uwv-my-suffix.component.html'
})
export class NawWerkgeverUWVMySuffixComponent implements OnInit, OnDestroy {
    nawWerkgeverUWVS: INawWerkgeverUWVMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private nawWerkgeverUWVService: NawWerkgeverUWVMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.nawWerkgeverUWVService.query().subscribe(
            (res: HttpResponse<INawWerkgeverUWVMySuffix[]>) => {
                this.nawWerkgeverUWVS = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInNawWerkgeverUWVS();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: INawWerkgeverUWVMySuffix) {
        return item.id;
    }

    registerChangeInNawWerkgeverUWVS() {
        this.eventSubscriber = this.eventManager.subscribe('nawWerkgeverUWVListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
