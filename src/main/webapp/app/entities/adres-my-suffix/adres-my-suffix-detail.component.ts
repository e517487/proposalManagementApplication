import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IAdresMySuffix } from 'app/shared/model/adres-my-suffix.model';

@Component({
    selector: 'jhi-adres-my-suffix-detail',
    templateUrl: './adres-my-suffix-detail.component.html'
})
export class AdresMySuffixDetailComponent implements OnInit {
    adres: IAdresMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ adres }) => {
            this.adres = adres;
        });
    }

    previousState() {
        window.history.back();
    }
}
