import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';
import { Record40AcceptatieScoreMySuffixService } from './record-40-acceptatie-score-my-suffix.service';

@Component({
    selector: 'jhi-record-40-acceptatie-score-my-suffix-update',
    templateUrl: './record-40-acceptatie-score-my-suffix-update.component.html'
})
export class Record40AcceptatieScoreMySuffixUpdateComponent implements OnInit {
    private _record40AcceptatieScore: IRecord40AcceptatieScoreMySuffix;
    isSaving: boolean;

    constructor(private record40AcceptatieScoreService: Record40AcceptatieScoreMySuffixService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord40AcceptatieScoreMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord40AcceptatieScoreMySuffix>) => this.onSaveSuccess(),
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

    set record40AcceptatieScore(record40AcceptatieScore: IRecord40AcceptatieScoreMySuffix) {
        this._record40AcceptatieScore = record40AcceptatieScore;
    }
}
