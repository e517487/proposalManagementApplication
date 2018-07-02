import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';

@Component({
    selector: 'jhi-header-my-suffix-detail',
    templateUrl: './header-my-suffix-detail.component.html'
})
export class HeaderMySuffixDetailComponent implements OnInit {
    header: IHeaderMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ header }) => {
            this.header = header;
        });
    }

    previousState() {
        window.history.back();
    }
}
