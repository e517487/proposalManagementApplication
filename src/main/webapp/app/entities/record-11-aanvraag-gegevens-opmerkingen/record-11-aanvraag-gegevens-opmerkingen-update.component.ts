import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';
import { Record11AanvraagGegevensOpmerkingenService } from './record-11-aanvraag-gegevens-opmerkingen.service';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-update',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-update.component.html'
})
export class Record11AanvraagGegevensOpmerkingenUpdateComponent implements OnInit {
    private _record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingen;
    isSaving: boolean;

    constructor(
        private record11AanvraagGegevensOpmerkingenService: Record11AanvraagGegevensOpmerkingenService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record11AanvraagGegevensOpmerkingen }) => {
            this.record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingen;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record11AanvraagGegevensOpmerkingen.id !== undefined) {
            this.subscribeToSaveResponse(this.record11AanvraagGegevensOpmerkingenService.update(this.record11AanvraagGegevensOpmerkingen));
        } else {
            this.subscribeToSaveResponse(this.record11AanvraagGegevensOpmerkingenService.create(this.record11AanvraagGegevensOpmerkingen));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord11AanvraagGegevensOpmerkingen>>) {
        result.subscribe(
            (res: HttpResponse<IRecord11AanvraagGegevensOpmerkingen>) => this.onSaveSuccess(),
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
    get record11AanvraagGegevensOpmerkingen() {
        return this._record11AanvraagGegevensOpmerkingen;
    }

    set record11AanvraagGegevensOpmerkingen(record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingen) {
        this._record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingen;
    }
}
