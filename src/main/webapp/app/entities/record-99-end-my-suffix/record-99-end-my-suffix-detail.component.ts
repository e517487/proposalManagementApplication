import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';

@Component({
    selector: 'jhi-record-99-end-my-suffix-detail',
    templateUrl: './record-99-end-my-suffix-detail.component.html'
})
export class Record99EndMySuffixDetailComponent implements OnInit {
    record99End: IRecord99EndMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record99End }) => {
            this.record99End = record99End;
        });
    }

    previousState() {
        window.history.back();
    }
}
