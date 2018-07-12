import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';

@Component({
    selector: 'jhi-record-01-start-my-suffix-detail',
    templateUrl: './record-01-start-my-suffix-detail.component.html'
})
export class Record01StartMySuffixDetailComponent implements OnInit {
    record01Start: IRecord01StartMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record01Start }) => {
            this.record01Start = record01Start;
        });
    }

    previousState() {
        window.history.back();
    }
}
