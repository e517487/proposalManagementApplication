import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';

@Component({
    selector: 'jhi-record-25-herfinancieering-detail',
    templateUrl: './record-25-herfinancieering-detail.component.html'
})
export class Record25HerfinancieeringDetailComponent implements OnInit {
    record25Herfinancieering: IRecord25Herfinancieering;

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
