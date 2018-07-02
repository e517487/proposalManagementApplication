import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IFinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';
import { FinancieleSituatieMySuffixService } from './financiele-situatie-my-suffix.service';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix';

@Component({
    selector: 'jhi-financiele-situatie-my-suffix-update',
    templateUrl: './financiele-situatie-my-suffix-update.component.html'
})
export class FinancieleSituatieMySuffixUpdateComponent implements OnInit {
    private _financieleSituatie: IFinancieleSituatieMySuffix;
    isSaving: boolean;

    fdnaanvragers: IFdnAanvragerMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private financieleSituatieService: FinancieleSituatieMySuffixService,
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ financieleSituatie }) => {
            this.financieleSituatie = financieleSituatie;
        });
        this.fdnAanvragerService.query().subscribe(
            (res: HttpResponse<IFdnAanvragerMySuffix[]>) => {
                this.fdnaanvragers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.financieleSituatie.id !== undefined) {
            this.subscribeToSaveResponse(this.financieleSituatieService.update(this.financieleSituatie));
        } else {
            this.subscribeToSaveResponse(this.financieleSituatieService.create(this.financieleSituatie));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IFinancieleSituatieMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IFinancieleSituatieMySuffix>) => this.onSaveSuccess(),
            (res: HttpErrorResponse) => this.onSaveError()
        );
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

    trackFdnAanvragerById(index: number, item: IFdnAanvragerMySuffix) {
        return item.id;
    }
    get financieleSituatie() {
        return this._financieleSituatie;
    }

    set financieleSituatie(financieleSituatie: IFinancieleSituatieMySuffix) {
        this._financieleSituatie = financieleSituatie;
    }
}
