import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IRecord99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';
import { Record99EndMySuffixService } from './record-99-end-my-suffix.service';

@Component({
    selector: 'jhi-record-99-end-my-suffix-update',
    templateUrl: './record-99-end-my-suffix-update.component.html'
})
export class Record99EndMySuffixUpdateComponent implements OnInit {
    private _record99End: IRecord99EndMySuffix;
    isSaving: boolean;
    creatieDatumDp: any;
    creatieTijd: string;

    constructor(private record99EndService: Record99EndMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record99End }) => {
            this.record99End = record99End;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.record99End.creatieTijd = moment(this.creatieTijd, DATE_TIME_FORMAT);
        if (this.record99End.id !== undefined) {
            this.subscribeToSaveResponse(this.record99EndService.update(this.record99End));
        } else {
            this.subscribeToSaveResponse(this.record99EndService.create(this.record99End));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord99EndMySuffix>>) {
        result.subscribe((res: HttpResponse<IRecord99EndMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get record99End() {
        return this._record99End;
    }

    set record99End(record99End: IRecord99EndMySuffix) {
        this._record99End = record99End;
        this.creatieTijd = moment(record99End.creatieTijd).format(DATE_TIME_FORMAT);
    }
}
