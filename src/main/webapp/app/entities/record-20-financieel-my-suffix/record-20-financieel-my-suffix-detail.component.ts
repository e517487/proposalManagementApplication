import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';

@Component({
    selector: 'jhi-record-20-financieel-my-suffix-detail',
    templateUrl: './record-20-financieel-my-suffix-detail.component.html'
})
export class Record20FinancieelMySuffixDetailComponent implements OnInit {
    record20Financieel: IRecord20FinancieelMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record20Financieel }) => {
            this.record20Financieel = record20Financieel;
        });
    }

    previousState() {
        window.history.back();
    }
}
