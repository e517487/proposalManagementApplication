import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ICreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';
import { CreditScoreMySuffixService } from './credit-score-my-suffix.service';
import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';
import { RequestMySuffixService } from 'app/entities/request-my-suffix';

@Component({
    selector: 'jhi-credit-score-my-suffix-update',
    templateUrl: './credit-score-my-suffix-update.component.html'
})
export class CreditScoreMySuffixUpdateComponent implements OnInit {
    private _creditScore: ICreditScoreMySuffix;
    isSaving: boolean;

    requests: IRequestMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private creditScoreService: CreditScoreMySuffixService,
        private requestService: RequestMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ creditScore }) => {
            this.creditScore = creditScore;
        });
        this.requestService.query({ filter: 'creditscore-is-null' }).subscribe(
            (res: HttpResponse<IRequestMySuffix[]>) => {
                if (!this.creditScore.requestId) {
                    this.requests = res.body;
                } else {
                    this.requestService.find(this.creditScore.requestId).subscribe(
                        (subRes: HttpResponse<IRequestMySuffix>) => {
                            this.requests = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.creditScore.id !== undefined) {
            this.subscribeToSaveResponse(this.creditScoreService.update(this.creditScore));
        } else {
            this.subscribeToSaveResponse(this.creditScoreService.create(this.creditScore));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ICreditScoreMySuffix>>) {
        result.subscribe((res: HttpResponse<ICreditScoreMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackRequestById(index: number, item: IRequestMySuffix) {
        return item.id;
    }
    get creditScore() {
        return this._creditScore;
    }

    set creditScore(creditScore: ICreditScoreMySuffix) {
        this._creditScore = creditScore;
    }
}
