import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord99Eind } from 'app/shared/model/record-99-eind.model';

@Component({
    selector: 'jhi-record-99-eind-detail',
    templateUrl: './record-99-eind-detail.component.html'
})
export class Record99EindDetailComponent implements OnInit {
    record99Eind: IRecord99Eind;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record99Eind }) => {
            this.record99Eind = record99Eind;
        });
    }

    previousState() {
        window.history.back();
    }
}
