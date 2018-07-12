import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord45Relatie } from 'app/shared/model/record-45-relatie.model';

@Component({
    selector: 'jhi-record-45-relatie-detail',
    templateUrl: './record-45-relatie-detail.component.html'
})
export class Record45RelatieDetailComponent implements OnInit {
    record45Relatie: IRecord45Relatie;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record45Relatie }) => {
            this.record45Relatie = record45Relatie;
        });
    }

    previousState() {
        window.history.back();
    }
}
