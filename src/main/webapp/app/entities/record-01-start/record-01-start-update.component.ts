import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IRecord01Start } from 'app/shared/model/record-01-start.model';
import { Record01StartService } from './record-01-start.service';

@Component({
    selector: 'jhi-record-01-start-update',
    templateUrl: './record-01-start-update.component.html'
})
export class Record01StartUpdateComponent implements OnInit {
    private _record01Start: IRecord01Start;
    isSaving: boolean;
    creatieDatumDp: any;
    creatieTijd: string;

    constructor(private record01StartService: Record01StartService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record01Start }) => {
            this.record01Start = record01Start;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.record01Start.creatieTijd = moment(this.creatieTijd, DATE_TIME_FORMAT);
        if (this.record01Start.id !== undefined) {
            this.subscribeToSaveResponse(this.record01StartService.update(this.record01Start));
        } else {
            this.subscribeToSaveResponse(this.record01StartService.create(this.record01Start));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord01Start>>) {
        result.subscribe((res: HttpResponse<IRecord01Start>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get record01Start() {
        return this._record01Start;
    }

    set record01Start(record01Start: IRecord01Start) {
        this._record01Start = record01Start;
        this.creatieTijd = moment(record01Start.creatieTijd).format(DATE_TIME_FORMAT);
    }
}
