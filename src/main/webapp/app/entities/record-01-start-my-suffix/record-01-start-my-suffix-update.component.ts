import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IRecord01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';
import { Record01StartMySuffixService } from './record-01-start-my-suffix.service';

@Component({
    selector: 'jhi-record-01-start-my-suffix-update',
    templateUrl: './record-01-start-my-suffix-update.component.html'
})
export class Record01StartMySuffixUpdateComponent implements OnInit {
    private _record01Start: IRecord01StartMySuffix;
    isSaving: boolean;
    creatieDatumDp: any;
    creatieTijd: string;

    constructor(private record01StartService: Record01StartMySuffixService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord01StartMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord01StartMySuffix>) => this.onSaveSuccess(),
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
    get record01Start() {
        return this._record01Start;
    }

    set record01Start(record01Start: IRecord01StartMySuffix) {
        this._record01Start = record01Start;
        this.creatieTijd = moment(record01Start.creatieTijd).format(DATE_TIME_FORMAT);
    }
}
