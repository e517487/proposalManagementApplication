import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord30Inruil } from 'app/shared/model/record-30-inruil.model';

@Component({
    selector: 'jhi-record-30-inruil-detail',
    templateUrl: './record-30-inruil-detail.component.html'
})
export class Record30InruilDetailComponent implements OnInit {
    record30Inruil: IRecord30Inruil;

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
