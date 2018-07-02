import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { INawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';
import { NawWerkgeverUWVMySuffixService } from './naw-werkgever-uwv-my-suffix.service';
import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';
import { WerksituatieMySuffixService } from 'app/entities/werksituatie-my-suffix';

@Component({
    selector: 'jhi-naw-werkgever-uwv-my-suffix-update',
    templateUrl: './naw-werkgever-uwv-my-suffix-update.component.html'
})
export class NawWerkgeverUWVMySuffixUpdateComponent implements OnInit {
    private _nawWerkgeverUWV: INawWerkgeverUWVMySuffix;
    isSaving: boolean;

    werksituaties: IWerksituatieMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private nawWerkgeverUWVService: NawWerkgeverUWVMySuffixService,
        private werksituatieService: WerksituatieMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ nawWerkgeverUWV }) => {
            this.nawWerkgeverUWV = nawWerkgeverUWV;
        });
        this.werksituatieService.query().subscribe(
            (res: HttpResponse<IWerksituatieMySuffix[]>) => {
                this.werksituaties = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.nawWerkgeverUWV.id !== undefined) {
            this.subscribeToSaveResponse(this.nawWerkgeverUWVService.update(this.nawWerkgeverUWV));
        } else {
            this.subscribeToSaveResponse(this.nawWerkgeverUWVService.create(this.nawWerkgeverUWV));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<INawWerkgeverUWVMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<INawWerkgeverUWVMySuffix>) => this.onSaveSuccess(),
            (res: HttpErrorResponse) => this.onSaveError()
        );
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackWerksituatieById(index: number, item: IWerksituatieMySuffix) {
        return item.id;
    }
    get nawWerkgeverUWV() {
        return this._nawWerkgeverUWV;
    }

    set nawWerkgeverUWV(nawWerkgeverUWV: INawWerkgeverUWVMySuffix) {
        this._nawWerkgeverUWV = nawWerkgeverUWV;
    }
}
