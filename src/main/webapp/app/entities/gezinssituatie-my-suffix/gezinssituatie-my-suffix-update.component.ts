import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IGezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';
import { GezinssituatieMySuffixService } from './gezinssituatie-my-suffix.service';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix';

@Component({
    selector: 'jhi-gezinssituatie-my-suffix-update',
    templateUrl: './gezinssituatie-my-suffix-update.component.html'
})
export class GezinssituatieMySuffixUpdateComponent implements OnInit {
    private _gezinssituatie: IGezinssituatieMySuffix;
    isSaving: boolean;

    fdnaanvragers: IFdnAanvragerMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private gezinssituatieService: GezinssituatieMySuffixService,
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ gezinssituatie }) => {
            this.gezinssituatie = gezinssituatie;
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
        if (this.gezinssituatie.id !== undefined) {
            this.subscribeToSaveResponse(this.gezinssituatieService.update(this.gezinssituatie));
        } else {
            this.subscribeToSaveResponse(this.gezinssituatieService.create(this.gezinssituatie));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IGezinssituatieMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IGezinssituatieMySuffix>) => this.onSaveSuccess(),
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
    get gezinssituatie() {
        return this._gezinssituatie;
    }

    set gezinssituatie(gezinssituatie: IGezinssituatieMySuffix) {
        this._gezinssituatie = gezinssituatie;
    }
}
