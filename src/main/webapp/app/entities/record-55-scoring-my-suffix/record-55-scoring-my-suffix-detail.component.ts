import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';

@Component({
    selector: 'jhi-record-55-scoring-my-suffix-detail',
    templateUrl: './record-55-scoring-my-suffix-detail.component.html'
})
export class Record55ScoringMySuffixDetailComponent implements OnInit {
    record55Scoring: IRecord55ScoringMySuffix;

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
