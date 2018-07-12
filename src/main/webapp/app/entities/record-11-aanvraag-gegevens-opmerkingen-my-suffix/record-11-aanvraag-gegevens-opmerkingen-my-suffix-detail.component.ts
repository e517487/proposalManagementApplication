import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-my-suffix-detail',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-my-suffix-detail.component.html'
})
export class Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent implements OnInit {
    record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingenMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record11AanvraagGegevensOpmerkingen }) => {
            this.record11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingen;
        });
    }

    previousState() {
        window.history.back();
    }
}
