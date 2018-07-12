import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IRecord99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';
import { Record99EindMySuffixService } from './record-99-eind-my-suffix.service';

@Component({
    selector: 'jhi-record-99-eind-my-suffix-update',
    templateUrl: './record-99-eind-my-suffix-update.component.html'
})
export class Record99EindMySuffixUpdateComponent implements OnInit {
    private _record99Eind: IRecord99EindMySuffix;
    isSaving: boolean;
    creatieDatumDp: any;
    creatieTijd: string;

    constructor(private record99EindService: Record99EindMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record99Eind }) => {
            this.record99Eind = record99Eind;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.record99Eind.creatieTijd = moment(this.creatieTijd, DATE_TIME_FORMAT);
        if (this.record99Eind.id !== undefined) {
            this.subscribeToSaveResponse(this.record99EindService.update(this.record99Eind));
        } else {
            this.subscribeToSaveResponse(this.record99EindService.create(this.record99Eind));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord99EindMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord99EindMySuffix>) => this.onSaveSuccess(),
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
    get record99Eind() {
        return this._record99Eind;
    }

    set record99Eind(record99Eind: IRecord99EindMySuffix) {
        this._record99Eind = record99Eind;
        this.creatieTijd = moment(record99Eind.creatieTijd).format(DATE_TIME_FORMAT);
    }
}
