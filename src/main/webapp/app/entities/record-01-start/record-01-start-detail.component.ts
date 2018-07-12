import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord01Start } from 'app/shared/model/record-01-start.model';

@Component({
    selector: 'jhi-record-01-start-detail',
    templateUrl: './record-01-start-detail.component.html'
})
export class Record01StartDetailComponent implements OnInit {
    record01Start: IRecord01Start;

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
