import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ILegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';

@Component({
    selector: 'jhi-legitimatiebewijs-my-suffix-detail',
    templateUrl: './legitimatiebewijs-my-suffix-detail.component.html'
})
export class LegitimatiebewijsMySuffixDetailComponent implements OnInit {
    legitimatiebewijs: ILegitimatiebewijsMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ legitimatiebewijs }) => {
            this.legitimatiebewijs = legitimatiebewijs;
        });
    }

    previousState() {
        window.history.back();
    }
}
