import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-detail',
    templateUrl: './record-10-aanvraag-gegevens-algemeen-detail.component.html'
})
export class Record10AanvraagGegevensAlgemeenDetailComponent implements OnInit {
    record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record10AanvraagGegevensAlgemeen }) => {
            this.record10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeen;
        });
    }

    previousState() {
        window.history.back();
    }
}
