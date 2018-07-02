import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';
import { WerksituatieMySuffixService } from './werksituatie-my-suffix.service';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix';

@Component({
    selector: 'jhi-werksituatie-my-suffix-update',
    templateUrl: './werksituatie-my-suffix-update.component.html'
})
export class WerksituatieMySuffixUpdateComponent implements OnInit {
    private _werksituatie: IWerksituatieMySuffix;
    isSaving: boolean;

    fdnaanvragers: IFdnAanvragerMySuffix[];
    beginDienstverbandDtDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private werksituatieService: WerksituatieMySuffixService,
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ werksituatie }) => {
            this.werksituatie = werksituatie;
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
        if (this.werksituatie.id !== undefined) {
            this.subscribeToSaveResponse(this.werksituatieService.update(this.werksituatie));
        } else {
            this.subscribeToSaveResponse(this.werksituatieService.create(this.werksituatie));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IWerksituatieMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IWerksituatieMySuffix>) => this.onSaveSuccess(),
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
    get werksituatie() {
        return this._werksituatie;
    }

    set werksituatie(werksituatie: IWerksituatieMySuffix) {
        this._werksituatie = werksituatie;
    }
}
