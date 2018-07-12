import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord20Financieel } from 'app/shared/model/record-20-financieel.model';
import { Record20FinancieelService } from './record-20-financieel.service';

@Component({
    selector: 'jhi-record-20-financieel-update',
    templateUrl: './record-20-financieel-update.component.html'
})
export class Record20FinancieelUpdateComponent implements OnInit {
    private _record20Financieel: IRecord20Financieel;
    isSaving: boolean;

    constructor(private record20FinancieelService: Record20FinancieelService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord20Financieel>>) {
        result.subscribe((res: HttpResponse<IRecord20Financieel>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    set record20Financieel(record20Financieel: IRecord20Financieel) {
        this._record20Financieel = record20Financieel;
    }
}
