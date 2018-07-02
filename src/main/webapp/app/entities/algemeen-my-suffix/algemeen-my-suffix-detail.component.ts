import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';

@Component({
    selector: 'jhi-algemeen-my-suffix-detail',
    templateUrl: './algemeen-my-suffix-detail.component.html'
})
export class AlgemeenMySuffixDetailComponent implements OnInit {
    algemeen: IAlgemeenMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ algemeen }) => {
            this.algemeen = algemeen;
        });
    }

    previousState() {
        window.history.back();
    }
}
