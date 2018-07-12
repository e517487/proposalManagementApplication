import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';

@Component({
    selector: 'jhi-record-30-inruil-my-suffix-detail',
    templateUrl: './record-30-inruil-my-suffix-detail.component.html'
})
export class Record30InruilMySuffixDetailComponent implements OnInit {
    record30Inruil: IRecord30InruilMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record30Inruil }) => {
            this.record30Inruil = record30Inruil;
        });
    }

    previousState() {
        window.history.back();
    }
}
