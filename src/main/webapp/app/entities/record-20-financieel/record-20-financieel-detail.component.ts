import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord20Financieel } from 'app/shared/model/record-20-financieel.model';

@Component({
    selector: 'jhi-record-20-financieel-detail',
    templateUrl: './record-20-financieel-detail.component.html'
})
export class Record20FinancieelDetailComponent implements OnInit {
    record20Financieel: IRecord20Financieel;

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
