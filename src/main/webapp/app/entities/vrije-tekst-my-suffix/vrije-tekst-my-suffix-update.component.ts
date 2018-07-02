import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';
import { VrijeTekstMySuffixService } from './vrije-tekst-my-suffix.service';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix';

@Component({
    selector: 'jhi-vrije-tekst-my-suffix-update',
    templateUrl: './vrije-tekst-my-suffix-update.component.html'
})
export class VrijeTekstMySuffixUpdateComponent implements OnInit {
    private _vrijeTekst: IVrijeTekstMySuffix;
    isSaving: boolean;

    aanvraagberichts: IAanvraagberichtMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private vrijeTekstService: VrijeTekstMySuffixService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ vrijeTekst }) => {
            this.vrijeTekst = vrijeTekst;
        });
        this.aanvraagberichtService.query().subscribe(
            (res: HttpResponse<IAanvraagberichtMySuffix[]>) => {
                this.aanvraagberichts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.vrijeTekst.id !== undefined) {
            this.subscribeToSaveResponse(this.vrijeTekstService.update(this.vrijeTekst));
        } else {
            this.subscribeToSaveResponse(this.vrijeTekstService.create(this.vrijeTekst));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IVrijeTekstMySuffix>>) {
        result.subscribe((res: HttpResponse<IVrijeTekstMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackAanvraagberichtById(index: number, item: IAanvraagberichtMySuffix) {
        return item.id;
    }
    get vrijeTekst() {
        return this._vrijeTekst;
    }

    set vrijeTekst(vrijeTekst: IVrijeTekstMySuffix) {
        this._vrijeTekst = vrijeTekst;
    }
}
