import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';
import { Record25HerfinancieeringService } from './record-25-herfinancieering.service';

@Component({
    selector: 'jhi-record-25-herfinancieering-update',
    templateUrl: './record-25-herfinancieering-update.component.html'
})
export class Record25HerfinancieeringUpdateComponent implements OnInit {
    private _record25Herfinancieering: IRecord25Herfinancieering;
    isSaving: boolean;

    constructor(private record25HerfinancieeringService: Record25HerfinancieeringService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record25Herfinancieering }) => {
            this.record25Herfinancieering = record25Herfinancieering;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record25Herfinancieering.id !== undefined) {
            this.subscribeToSaveResponse(this.record25HerfinancieeringService.update(this.record25Herfinancieering));
        } else {
            this.subscribeToSaveResponse(this.record25HerfinancieeringService.create(this.record25Herfinancieering));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord25Herfinancieering>>) {
        result.subscribe(
            (res: HttpResponse<IRecord25Herfinancieering>) => this.onSaveSuccess(),
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
    get record25Herfinancieering() {
        return this._record25Herfinancieering;
    }

    set record25Herfinancieering(record25Herfinancieering: IRecord25Herfinancieering) {
        this._record25Herfinancieering = record25Herfinancieering;
    }
}
