import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';

@Component({
    selector: 'jhi-record-62-uitleg-my-suffix-detail',
    templateUrl: './record-62-uitleg-my-suffix-detail.component.html'
})
export class Record62UitlegMySuffixDetailComponent implements OnInit {
    record62Uitleg: IRecord62UitlegMySuffix;

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
