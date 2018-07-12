import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord62Uitleg } from 'app/shared/model/record-62-uitleg.model';

@Component({
    selector: 'jhi-record-62-uitleg-detail',
    templateUrl: './record-62-uitleg-detail.component.html'
})
export class Record62UitlegDetailComponent implements OnInit {
    record62Uitleg: IRecord62Uitleg;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record62Uitleg }) => {
            this.record62Uitleg = record62Uitleg;
        });
    }

    previousState() {
        window.history.back();
    }
}
