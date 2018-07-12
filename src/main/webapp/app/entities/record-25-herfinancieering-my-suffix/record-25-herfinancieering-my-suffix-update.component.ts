import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';
import { Record25HerfinancieeringMySuffixService } from './record-25-herfinancieering-my-suffix.service';

@Component({
    selector: 'jhi-record-25-herfinancieering-my-suffix-update',
    templateUrl: './record-25-herfinancieering-my-suffix-update.component.html'
})
export class Record25HerfinancieeringMySuffixUpdateComponent implements OnInit {
    private _record25Herfinancieering: IRecord25HerfinancieeringMySuffix;
    isSaving: boolean;

    constructor(private record25HerfinancieeringService: Record25HerfinancieeringMySuffixService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord25HerfinancieeringMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord25HerfinancieeringMySuffix>) => this.onSaveSuccess(),
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

    set record25Herfinancieering(record25Herfinancieering: IRecord25HerfinancieeringMySuffix) {
        this._record25Herfinancieering = record25Herfinancieering;
    }
}
