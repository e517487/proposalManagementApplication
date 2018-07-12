import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';
import { Record46RelatieHuishoudelijkService } from './record-46-relatie-huishoudelijk.service';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-update',
    templateUrl: './record-46-relatie-huishoudelijk-update.component.html'
})
export class Record46RelatieHuishoudelijkUpdateComponent implements OnInit {
    private _record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijk;
    isSaving: boolean;

    constructor(private record46RelatieHuishoudelijkService: Record46RelatieHuishoudelijkService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record46RelatieHuishoudelijk }) => {
            this.record46RelatieHuishoudelijk = record46RelatieHuishoudelijk;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record46RelatieHuishoudelijk.id !== undefined) {
            this.subscribeToSaveResponse(this.record46RelatieHuishoudelijkService.update(this.record46RelatieHuishoudelijk));
        } else {
            this.subscribeToSaveResponse(this.record46RelatieHuishoudelijkService.create(this.record46RelatieHuishoudelijk));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord46RelatieHuishoudelijk>>) {
        result.subscribe(
            (res: HttpResponse<IRecord46RelatieHuishoudelijk>) => this.onSaveSuccess(),
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
    get record46RelatieHuishoudelijk() {
        return this._record46RelatieHuishoudelijk;
    }

    set record46RelatieHuishoudelijk(record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijk) {
        this._record46RelatieHuishoudelijk = record46RelatieHuishoudelijk;
    }
}
