import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';

@Component({
    selector: 'jhi-record-11-aanvraag-gegevens-opmerkingen-detail',
    templateUrl: './record-11-aanvraag-gegevens-opmerkingen-detail.component.html'
})
export class Record11AanvraagGegevensOpmerkingenDetailComponent implements OnInit {
    record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingen;

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
