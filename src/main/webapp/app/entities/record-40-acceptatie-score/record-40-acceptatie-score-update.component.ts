import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';
import { Record40AcceptatieScoreService } from './record-40-acceptatie-score.service';

@Component({
    selector: 'jhi-record-40-acceptatie-score-update',
    templateUrl: './record-40-acceptatie-score-update.component.html'
})
export class Record40AcceptatieScoreUpdateComponent implements OnInit {
    private _record40AcceptatieScore: IRecord40AcceptatieScore;
    isSaving: boolean;

    constructor(private record40AcceptatieScoreService: Record40AcceptatieScoreService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record40AcceptatieScore }) => {
            this.record40AcceptatieScore = record40AcceptatieScore;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record40AcceptatieScore.id !== undefined) {
            this.subscribeToSaveResponse(this.record40AcceptatieScoreService.update(this.record40AcceptatieScore));
        } else {
            this.subscribeToSaveResponse(this.record40AcceptatieScoreService.create(this.record40AcceptatieScore));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord40AcceptatieScore>>) {
        result.subscribe(
            (res: HttpResponse<IRecord40AcceptatieScore>) => this.onSaveSuccess(),
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
    get record40AcceptatieScore() {
        return this._record40AcceptatieScore;
    }

    set record40AcceptatieScore(record40AcceptatieScore: IRecord40AcceptatieScore) {
        this._record40AcceptatieScore = record40AcceptatieScore;
    }
}
