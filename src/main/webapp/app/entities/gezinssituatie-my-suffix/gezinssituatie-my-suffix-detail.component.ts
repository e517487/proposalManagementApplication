import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IGezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';

@Component({
    selector: 'jhi-gezinssituatie-my-suffix-detail',
    templateUrl: './gezinssituatie-my-suffix-detail.component.html'
})
export class GezinssituatieMySuffixDetailComponent implements OnInit {
    gezinssituatie: IGezinssituatieMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ gezinssituatie }) => {
            this.gezinssituatie = gezinssituatie;
        });
    }

    previousState() {
        window.history.back();
    }
}
