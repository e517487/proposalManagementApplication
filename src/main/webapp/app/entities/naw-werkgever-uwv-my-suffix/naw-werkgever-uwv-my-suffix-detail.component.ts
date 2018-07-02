import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { INawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';

@Component({
    selector: 'jhi-naw-werkgever-uwv-my-suffix-detail',
    templateUrl: './naw-werkgever-uwv-my-suffix-detail.component.html'
})
export class NawWerkgeverUWVMySuffixDetailComponent implements OnInit {
    nawWerkgeverUWV: INawWerkgeverUWVMySuffix;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ nawWerkgeverUWV }) => {
            this.nawWerkgeverUWV = nawWerkgeverUWV;
        });
    }

    previousState() {
        window.history.back();
    }
}
