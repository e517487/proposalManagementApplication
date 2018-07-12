import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';
import { RequestMySuffixService } from './request-my-suffix.service';
import { ICreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';
import { CreditScoreMySuffixService } from 'app/entities/credit-score-my-suffix';
import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';
import { RekenmoduleAanvraagMySuffixService } from 'app/entities/rekenmodule-aanvraag-my-suffix';
import { ICustomerMySuffix } from 'app/shared/model/customer-my-suffix.model';
import { CustomerMySuffixService } from 'app/entities/customer-my-suffix';

@Component({
    selector: 'jhi-request-my-suffix-update',
    templateUrl: './request-my-suffix-update.component.html'
})
export class RequestMySuffixUpdateComponent implements OnInit {
    private _request: IRequestMySuffix;
    isSaving: boolean;

    creditscores: ICreditScoreMySuffix[];

    rekenmoduleaanvraags: IRekenmoduleAanvraagMySuffix[];

    customers: ICustomerMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private requestService: RequestMySuffixService,
        private creditScoreService: CreditScoreMySuffixService,
        private rekenmoduleAanvraagService: RekenmoduleAanvraagMySuffixService,
        private customerService: CustomerMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ request }) => {
            this.request = request;
        });
        this.creditScoreService.query().subscribe(
            (res: HttpResponse<ICreditScoreMySuffix[]>) => {
                this.creditscores = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.rekenmoduleAanvraagService.query().subscribe(
            (res: HttpResponse<IRekenmoduleAanvraagMySuffix[]>) => {
                this.rekenmoduleaanvraags = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.customerService.query().subscribe(
            (res: HttpResponse<ICustomerMySuffix[]>) => {
                this.customers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.request.id !== undefined) {
            this.subscribeToSaveResponse(this.requestService.update(this.request));
        } else {
            this.subscribeToSaveResponse(this.requestService.create(this.request));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRequestMySuffix>>) {
        result.subscribe((res: HttpResponse<IRequestMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackCreditScoreById(index: number, item: ICreditScoreMySuffix) {
        return item.id;
    }

    trackRekenmoduleAanvraagById(index: number, item: IRekenmoduleAanvraagMySuffix) {
        return item.id;
    }

    trackCustomerById(index: number, item: ICustomerMySuffix) {
        return item.id;
    }
    get request() {
        return this._request;
    }

    set request(request: IRequestMySuffix) {
        this._request = request;
    }
}
