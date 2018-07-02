import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';

@Component({
    selector: 'jhi-request-my-suffix-detail',
    templateUrl: './request-my-suffix-detail.component.html'
})
export class RequestMySuffixDetailComponent implements OnInit {
    request: IRequestMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ request }) => {
            this.request = request;
        });
    }

    previousState() {
        window.history.back();
    }
}
