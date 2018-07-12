import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';
import { Record55ScoringMySuffixService } from './record-55-scoring-my-suffix.service';

@Component({
    selector: 'jhi-record-55-scoring-my-suffix-update',
    templateUrl: './record-55-scoring-my-suffix-update.component.html'
})
export class Record55ScoringMySuffixUpdateComponent implements OnInit {
    private _record55Scoring: IRecord55ScoringMySuffix;
    isSaving: boolean;

    constructor(private record55ScoringService: Record55ScoringMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record55Scoring }) => {
            this.record55Scoring = record55Scoring;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record55Scoring.id !== undefined) {
            this.subscribeToSaveResponse(this.record55ScoringService.update(this.record55Scoring));
        } else {
            this.subscribeToSaveResponse(this.record55ScoringService.create(this.record55Scoring));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord55ScoringMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord55ScoringMySuffix>) => this.onSaveSuccess(),
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
    get record55Scoring() {
        return this._record55Scoring;
    }

    set record55Scoring(record55Scoring: IRecord55ScoringMySuffix) {
        this._record55Scoring = record55Scoring;
    }
}
