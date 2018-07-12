import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord63Uitleg } from 'app/shared/model/record-63-uitleg.model';

@Component({
    selector: 'jhi-record-63-uitleg-detail',
    templateUrl: './record-63-uitleg-detail.component.html'
})
export class Record63UitlegDetailComponent implements OnInit {
    record63Uitleg: IRecord63Uitleg;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record63Uitleg }) => {
            this.record63Uitleg = record63Uitleg;
        });
    }

    previousState() {
        window.history.back();
    }
}
