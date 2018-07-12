import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-my-suffix-detail',
    templateUrl: './record-46-relatie-huishoudelijk-my-suffix-detail.component.html'
})
export class Record46RelatieHuishoudelijkMySuffixDetailComponent implements OnInit {
    record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijkMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record46RelatieHuishoudelijk }) => {
            this.record46RelatieHuishoudelijk = record46RelatieHuishoudelijk;
        });
    }

    previousState() {
        window.history.back();
    }
}
