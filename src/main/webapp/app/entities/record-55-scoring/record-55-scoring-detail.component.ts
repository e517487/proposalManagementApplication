import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord55Scoring } from 'app/shared/model/record-55-scoring.model';

@Component({
    selector: 'jhi-record-55-scoring-detail',
    templateUrl: './record-55-scoring-detail.component.html'
})
export class Record55ScoringDetailComponent implements OnInit {
    record55Scoring: IRecord55Scoring;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record55Scoring }) => {
            this.record55Scoring = record55Scoring;
        });
    }

    previousState() {
        window.history.back();
    }
}
