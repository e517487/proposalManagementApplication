import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';

@Component({
    selector: 'jhi-record-61-uitleg-my-suffix-detail',
    templateUrl: './record-61-uitleg-my-suffix-detail.component.html'
})
export class Record61UitlegMySuffixDetailComponent implements OnInit {
    record61Uitleg: IRecord61UitlegMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record61Uitleg }) => {
            this.record61Uitleg = record61Uitleg;
        });
    }

    previousState() {
        window.history.back();
    }
}
