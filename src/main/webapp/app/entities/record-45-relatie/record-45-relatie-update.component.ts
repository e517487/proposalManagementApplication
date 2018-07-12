import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord45Relatie } from 'app/shared/model/record-45-relatie.model';
import { Record45RelatieService } from './record-45-relatie.service';

@Component({
    selector: 'jhi-record-45-relatie-update',
    templateUrl: './record-45-relatie-update.component.html'
})
export class Record45RelatieUpdateComponent implements OnInit {
    private _record45Relatie: IRecord45Relatie;
    isSaving: boolean;

    constructor(private record45RelatieService: Record45RelatieService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record45Relatie }) => {
            this.record45Relatie = record45Relatie;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record45Relatie.id !== undefined) {
            this.subscribeToSaveResponse(this.record45RelatieService.update(this.record45Relatie));
        } else {
            this.subscribeToSaveResponse(this.record45RelatieService.create(this.record45Relatie));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord45Relatie>>) {
        result.subscribe((res: HttpResponse<IRecord45Relatie>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get record45Relatie() {
        return this._record45Relatie;
    }

    set record45Relatie(record45Relatie: IRecord45Relatie) {
        this._record45Relatie = record45Relatie;
    }
}
