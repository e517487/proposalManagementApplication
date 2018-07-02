import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';

@Component({
    selector: 'jhi-tekst-regel-my-suffix-detail',
    templateUrl: './tekst-regel-my-suffix-detail.component.html'
})
export class TekstRegelMySuffixDetailComponent implements OnInit {
    tekstRegel: ITekstRegelMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ tekstRegel }) => {
            this.tekstRegel = tekstRegel;
        });
    }

    previousState() {
        window.history.back();
    }
}
