import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';
import { Record45RelatieMySuffixService } from './record-45-relatie-my-suffix.service';

@Component({
    selector: 'jhi-record-45-relatie-my-suffix-update',
    templateUrl: './record-45-relatie-my-suffix-update.component.html'
})
export class Record45RelatieMySuffixUpdateComponent implements OnInit {
    private _record45Relatie: IRecord45RelatieMySuffix;
    isSaving: boolean;

    constructor(private record45RelatieService: Record45RelatieMySuffixService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord45RelatieMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord45RelatieMySuffix>) => this.onSaveSuccess(),
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
    get record45Relatie() {
        return this._record45Relatie;
    }

    set record45Relatie(record45Relatie: IRecord45RelatieMySuffix) {
        this._record45Relatie = record45Relatie;
    }
}
