import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-my-suffix-update',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-my-suffix-update.component.html'
})
export class Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent implements OnInit {
    private _record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingenMySuffix;
    isSaving: boolean;

    constructor(
        private record11AanvraagGegevensOpmerkingenService: Record11AanvraagGegevensOpmerkingenMySuffixService,
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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord11AanvraagGegevensOpmerkingenMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord11AanvraagGegevensOpmerkingenMySuffix>) => this.onSaveSuccess(),
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

    set record11AanvraagGegevensOpmerkingen(record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingenMySuffix) {
        this._record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingen;
    }
}
