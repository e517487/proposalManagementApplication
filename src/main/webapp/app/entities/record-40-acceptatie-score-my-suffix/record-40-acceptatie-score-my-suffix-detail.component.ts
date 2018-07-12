import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';

@Component({
    selector: 'jhi-record-40-acceptatie-score-my-suffix-detail',
    templateUrl: './record-40-acceptatie-score-my-suffix-detail.component.html'
})
export class Record40AcceptatieScoreMySuffixDetailComponent implements OnInit {
    record40AcceptatieScore: IRecord40AcceptatieScoreMySuffix;

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
