import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';
import { Record46RelatieHuishoudelijkMySuffixService } from './record-46-relatie-huishoudelijk-my-suffix.service';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-my-suffix-update',
    templateUrl: './record-46-relatie-huishoudelijk-my-suffix-update.component.html'
})
export class Record46RelatieHuishoudelijkMySuffixUpdateComponent implements OnInit {
    private _record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijkMySuffix;
    isSaving: boolean;

    constructor(
        private record46RelatieHuishoudelijkService: Record46RelatieHuishoudelijkMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord46RelatieHuishoudelijkMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord46RelatieHuishoudelijkMySuffix>) => this.onSaveSuccess(),
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

    set record46RelatieHuishoudelijk(record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijkMySuffix) {
        this._record46RelatieHuishoudelijk = record46RelatieHuishoudelijk;
    }
}
