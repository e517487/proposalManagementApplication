import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';

@Component({
    selector: 'jhi-aanvraagbericht-my-suffix-detail',
    templateUrl: './aanvraagbericht-my-suffix-detail.component.html'
})
export class AanvraagberichtMySuffixDetailComponent implements OnInit {
    aanvraagbericht: IAanvraagberichtMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ aanvraagbericht }) => {
            this.aanvraagbericht = aanvraagbericht;
        });
    }

    previousState() {
        window.history.back();
    }
}
