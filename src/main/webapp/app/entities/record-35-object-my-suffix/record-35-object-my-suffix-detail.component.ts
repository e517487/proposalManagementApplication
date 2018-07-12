import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';

@Component({
    selector: 'jhi-record-35-object-my-suffix-detail',
    templateUrl: './record-35-object-my-suffix-detail.component.html'
})
export class Record35ObjectMySuffixDetailComponent implements OnInit {
    record35Object: IRecord35ObjectMySuffix;

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
