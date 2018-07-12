import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IRecord10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';
import { Record10AanvraagGegevensAlgemeenService } from './record-10-aanvraag-gegevens-algemeen.service';

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-update',
    templateUrl: './record-10-aanvraag-gegevens-algemeen-update.component.html'
})
export class Record10AanvraagGegevensAlgemeenUpdateComponent implements OnInit {
    private _record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen;
    isSaving: boolean;
    aanvangDatumDp: any;
    aanvangTijd: string;
    acceptatieDatumDp: any;
    acceptatieTijd: string;
    prtDatumDp: any;

    constructor(
        private record10AanvraagGegevensAlgemeenService: Record10AanvraagGegevensAlgemeenService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record10AanvraagGegevensAlgemeen }) => {
            this.record10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeen;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.record10AanvraagGegevensAlgemeen.aanvangTijd = moment(this.aanvangTijd, DATE_TIME_FORMAT);
        this.record10AanvraagGegevensAlgemeen.acceptatieTijd = moment(this.acceptatieTijd, DATE_TIME_FORMAT);
        if (this.record10AanvraagGegevensAlgemeen.id !== undefined) {
            this.subscribeToSaveResponse(this.record10AanvraagGegevensAlgemeenService.update(this.record10AanvraagGegevensAlgemeen));
        } else {
            this.subscribeToSaveResponse(this.record10AanvraagGegevensAlgemeenService.create(this.record10AanvraagGegevensAlgemeen));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord10AanvraagGegevensAlgemeen>>) {
        result.subscribe(
            (res: HttpResponse<IRecord10AanvraagGegevensAlgemeen>) => this.onSaveSuccess(),
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
    get record10AanvraagGegevensAlgemeen() {
        return this._record10AanvraagGegevensAlgemeen;
    }

    set record10AanvraagGegevensAlgemeen(record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen) {
        this._record10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeen;
        this.aanvangTijd = moment(record10AanvraagGegevensAlgemeen.aanvangTijd).format(DATE_TIME_FORMAT);
        this.acceptatieTijd = moment(record10AanvraagGegevensAlgemeen.acceptatieTijd).format(DATE_TIME_FORMAT);
    }
}
