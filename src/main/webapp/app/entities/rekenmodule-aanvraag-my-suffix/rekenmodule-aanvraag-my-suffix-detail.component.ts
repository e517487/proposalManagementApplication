import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';

@Component({
    selector: 'jhi-rekenmodule-aanvraag-my-suffix-detail',
    templateUrl: './rekenmodule-aanvraag-my-suffix-detail.component.html'
})
export class RekenmoduleAanvraagMySuffixDetailComponent implements OnInit {
    rekenmoduleAanvraag: IRekenmoduleAanvraagMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ rekenmoduleAanvraag }) => {
            this.rekenmoduleAanvraag = rekenmoduleAanvraag;
        });
    }

    previousState() {
        window.history.back();
    }
}
