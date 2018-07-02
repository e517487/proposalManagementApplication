import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IKredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';

@Component({
    selector: 'jhi-krediet-aanvraag-my-suffix-detail',
    templateUrl: './krediet-aanvraag-my-suffix-detail.component.html'
})
export class KredietAanvraagMySuffixDetailComponent implements OnInit {
    kredietAanvraag: IKredietAanvraagMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ kredietAanvraag }) => {
            this.kredietAanvraag = kredietAanvraag;
        });
    }

    previousState() {
        window.history.back();
    }
}
