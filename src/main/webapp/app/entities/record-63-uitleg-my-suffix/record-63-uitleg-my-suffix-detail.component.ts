import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';

@Component({
    selector: 'jhi-record-63-uitleg-my-suffix-detail',
    templateUrl: './record-63-uitleg-my-suffix-detail.component.html'
})
export class Record63UitlegMySuffixDetailComponent implements OnInit {
    record63Uitleg: IRecord63UitlegMySuffix;

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
