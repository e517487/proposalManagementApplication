import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';
import { Record20FinancieelMySuffixService } from './record-20-financieel-my-suffix.service';

@Component({
    selector: 'jhi-record-20-financieel-my-suffix-update',
    templateUrl: './record-20-financieel-my-suffix-update.component.html'
})
export class Record20FinancieelMySuffixUpdateComponent implements OnInit {
    private _record20Financieel: IRecord20FinancieelMySuffix;
    isSaving: boolean;

    constructor(private record20FinancieelService: Record20FinancieelMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record20Financieel }) => {
            this.record20Financieel = record20Financieel;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record20Financieel.id !== undefined) {
            this.subscribeToSaveResponse(this.record20FinancieelService.update(this.record20Financieel));
        } else {
            this.subscribeToSaveResponse(this.record20FinancieelService.create(this.record20Financieel));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord20FinancieelMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord20FinancieelMySuffix>) => this.onSaveSuccess(),
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
    get record20Financieel() {
        return this._record20Financieel;
    }

    set record20Financieel(record20Financieel: IRecord20FinancieelMySuffix) {
        this._record20Financieel = record20Financieel;
    }
}
