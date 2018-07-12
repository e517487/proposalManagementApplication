import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord61Uitleg } from 'app/shared/model/record-61-uitleg.model';

@Component({
    selector: 'jhi-record-61-uitleg-detail',
    templateUrl: './record-61-uitleg-detail.component.html'
})
export class Record61UitlegDetailComponent implements OnInit {
    record61Uitleg: IRecord61Uitleg;

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
