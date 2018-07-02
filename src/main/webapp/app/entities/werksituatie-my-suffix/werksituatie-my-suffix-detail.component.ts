import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';

@Component({
    selector: 'jhi-werksituatie-my-suffix-detail',
    templateUrl: './werksituatie-my-suffix-detail.component.html'
})
export class WerksituatieMySuffixDetailComponent implements OnInit {
    werksituatie: IWerksituatieMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ werksituatie }) => {
            this.werksituatie = werksituatie;
        });
    }

    previousState() {
        window.history.back();
    }
}
