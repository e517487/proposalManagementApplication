import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';

@Component({
    selector: 'jhi-record-99-eind-my-suffix-detail',
    templateUrl: './record-99-eind-my-suffix-detail.component.html'
})
export class Record99EindMySuffixDetailComponent implements OnInit {
    record99Eind: IRecord99EindMySuffix;

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
