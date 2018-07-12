import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';

@Component({
    selector: 'jhi-record-50-bedrijf-my-suffix-detail',
    templateUrl: './record-50-bedrijf-my-suffix-detail.component.html'
})
export class Record50BedrijfMySuffixDetailComponent implements OnInit {
    record50Bedrijf: IRecord50BedrijfMySuffix;

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
