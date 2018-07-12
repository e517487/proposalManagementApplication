import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';

@Component({
    selector: 'jhi-record-50-bedrijf-detail',
    templateUrl: './record-50-bedrijf-detail.component.html'
})
export class Record50BedrijfDetailComponent implements OnInit {
    record50Bedrijf: IRecord50Bedrijf;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ record50Bedrijf }) => {
            this.record50Bedrijf = record50Bedrijf;
        });
    }

    previousState() {
        window.history.back();
    }
}
