import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ITekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';
import { TekstRegelMySuffixService } from './tekst-regel-my-suffix.service';
import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';
import { VrijeTekstMySuffixService } from 'app/entities/vrije-tekst-my-suffix';

@Component({
    selector: 'jhi-tekst-regel-my-suffix-update',
    templateUrl: './tekst-regel-my-suffix-update.component.html'
})
export class TekstRegelMySuffixUpdateComponent implements OnInit {
    private _tekstRegel: ITekstRegelMySuffix;
    isSaving: boolean;

    vrijeteksts: IVrijeTekstMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private tekstRegelService: TekstRegelMySuffixService,
        private vrijeTekstService: VrijeTekstMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tekstRegel }) => {
            this.tekstRegel = tekstRegel;
        });
        this.vrijeTekstService.query().subscribe(
            (res: HttpResponse<IVrijeTekstMySuffix[]>) => {
                this.vrijeteksts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.tekstRegel.id !== undefined) {
            this.subscribeToSaveResponse(this.tekstRegelService.update(this.tekstRegel));
        } else {
            this.subscribeToSaveResponse(this.tekstRegelService.create(this.tekstRegel));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ITekstRegelMySuffix>>) {
        result.subscribe((res: HttpResponse<ITekstRegelMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackVrijeTekstById(index: number, item: IVrijeTekstMySuffix) {
        return item.id;
    }
    get tekstRegel() {
        return this._tekstRegel;
    }

    set tekstRegel(tekstRegel: ITekstRegelMySuffix) {
        this._tekstRegel = tekstRegel;
    }
}
