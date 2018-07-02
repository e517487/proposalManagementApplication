import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IFinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';

@Component({
    selector: 'jhi-financiele-situatie-my-suffix-detail',
    templateUrl: './financiele-situatie-my-suffix-detail.component.html'
})
export class FinancieleSituatieMySuffixDetailComponent implements OnInit {
    financieleSituatie: IFinancieleSituatieMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ financieleSituatie }) => {
            this.financieleSituatie = financieleSituatie;
        });
    }

    previousState() {
        window.history.back();
    }
}
