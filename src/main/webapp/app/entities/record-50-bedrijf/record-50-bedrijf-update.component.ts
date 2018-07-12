import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';
import { Record50BedrijfService } from './record-50-bedrijf.service';

@Component({
    selector: 'jhi-record-50-bedrijf-update',
    templateUrl: './record-50-bedrijf-update.component.html'
})
export class Record50BedrijfUpdateComponent implements OnInit {
    private _record50Bedrijf: IRecord50Bedrijf;
    isSaving: boolean;

    constructor(private record50BedrijfService: Record50BedrijfService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record50Bedrijf }) => {
            this.record50Bedrijf = record50Bedrijf;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record50Bedrijf.id !== undefined) {
            this.subscribeToSaveResponse(this.record50BedrijfService.update(this.record50Bedrijf));
        } else {
            this.subscribeToSaveResponse(this.record50BedrijfService.create(this.record50Bedrijf));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord50Bedrijf>>) {
        result.subscribe((res: HttpResponse<IRecord50Bedrijf>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get record50Bedrijf() {
        return this._record50Bedrijf;
    }

    set record50Bedrijf(record50Bedrijf: IRecord50Bedrijf) {
        this._record50Bedrijf = record50Bedrijf;
    }
}
