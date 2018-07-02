import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';

@Component({
    selector: 'jhi-vrije-tekst-my-suffix-detail',
    templateUrl: './vrije-tekst-my-suffix-detail.component.html'
})
export class VrijeTekstMySuffixDetailComponent implements OnInit {
    vrijeTekst: IVrijeTekstMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ vrijeTekst }) => {
            this.vrijeTekst = vrijeTekst;
        });
    }

    previousState() {
        window.history.back();
    }
}
