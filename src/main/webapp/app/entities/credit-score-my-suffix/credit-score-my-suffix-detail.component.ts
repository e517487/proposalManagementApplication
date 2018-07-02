import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';

@Component({
    selector: 'jhi-credit-score-my-suffix-detail',
    templateUrl: './credit-score-my-suffix-detail.component.html'
})
export class CreditScoreMySuffixDetailComponent implements OnInit {
    creditScore: ICreditScoreMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ creditScore }) => {
            this.creditScore = creditScore;
        });
    }

    previousState() {
        window.history.back();
    }
}
