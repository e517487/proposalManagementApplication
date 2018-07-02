import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';

@Component({
    selector: 'jhi-fdn-aanvrager-my-suffix-detail',
    templateUrl: './fdn-aanvrager-my-suffix-detail.component.html'
})
export class FdnAanvragerMySuffixDetailComponent implements OnInit {
    fdnAanvrager: IFdnAanvragerMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ fdnAanvrager }) => {
            this.fdnAanvrager = fdnAanvrager;
        });
    }

    previousState() {
        window.history.back();
    }
}
