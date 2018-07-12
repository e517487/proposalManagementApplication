import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord35Object } from 'app/shared/model/record-35-object.model';

@Component({
    selector: 'jhi-record-35-object-detail',
    templateUrl: './record-35-object-detail.component.html'
})
export class Record35ObjectDetailComponent implements OnInit {
    record35Object: IRecord35Object;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record35Object }) => {
            this.record35Object = record35Object;
        });
    }

    previousState() {
        window.history.back();
    }
}
