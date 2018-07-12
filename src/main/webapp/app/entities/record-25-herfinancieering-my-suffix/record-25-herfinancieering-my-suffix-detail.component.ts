import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';

@Component({
    selector: 'jhi-record-25-herfinancieering-my-suffix-detail',
    templateUrl: './record-25-herfinancieering-my-suffix-detail.component.html'
})
export class Record25HerfinancieeringMySuffixDetailComponent implements OnInit {
    record25Herfinancieering: IRecord25HerfinancieeringMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record25Herfinancieering }) => {
            this.record25Herfinancieering = record25Herfinancieering;
        });
    }

    previousState() {
        window.history.back();
    }
}
