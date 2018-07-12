import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';

@Component({
    selector: 'jhi-record-46-relatie-huishoudelijk-detail',
    templateUrl: './record-46-relatie-huishoudelijk-detail.component.html'
})
export class Record46RelatieHuishoudelijkDetailComponent implements OnInit {
    record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijk;

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
