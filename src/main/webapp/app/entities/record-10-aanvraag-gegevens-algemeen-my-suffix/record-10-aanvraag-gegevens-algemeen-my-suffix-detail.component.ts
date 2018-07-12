import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';

@Component({
    selector: 'jhi-record-10-aanvraag-gegevens-algemeen-my-suffix-detail',
    templateUrl: './record-10-aanvraag-gegevens-algemeen-my-suffix-detail.component.html'
})
export class Record10AanvraagGegevensAlgemeenMySuffixDetailComponent implements OnInit {
    record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeenMySuffix;

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
