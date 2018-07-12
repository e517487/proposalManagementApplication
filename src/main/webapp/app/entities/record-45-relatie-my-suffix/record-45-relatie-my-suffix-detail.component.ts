import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRecord45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';

@Component({
    selector: 'jhi-record-45-relatie-my-suffix-detail',
    templateUrl: './record-45-relatie-my-suffix-detail.component.html'
})
export class Record45RelatieMySuffixDetailComponent implements OnInit {
    record45Relatie: IRecord45RelatieMySuffix;

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
