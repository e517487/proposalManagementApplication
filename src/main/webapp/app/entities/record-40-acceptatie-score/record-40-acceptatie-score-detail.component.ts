import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';

@Component({
    selector: 'jhi-record-40-acceptatie-score-detail',
    templateUrl: './record-40-acceptatie-score-detail.component.html'
})
export class Record40AcceptatieScoreDetailComponent implements OnInit {
    record40AcceptatieScore: IRecord40AcceptatieScore;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record40AcceptatieScore }) => {
            this.record40AcceptatieScore = record40AcceptatieScore;
        });
    }

    previousState() {
        window.history.back();
    }
}
