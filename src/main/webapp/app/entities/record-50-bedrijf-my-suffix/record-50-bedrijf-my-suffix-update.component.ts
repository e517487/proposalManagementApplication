import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';
import { Record50BedrijfMySuffixService } from './record-50-bedrijf-my-suffix.service';

@Component({
    selector: 'jhi-record-50-bedrijf-my-suffix-update',
    templateUrl: './record-50-bedrijf-my-suffix-update.component.html'
})
export class Record50BedrijfMySuffixUpdateComponent implements OnInit {
    private _record50Bedrijf: IRecord50BedrijfMySuffix;
    isSaving: boolean;

    constructor(private record50BedrijfService: Record50BedrijfMySuffixService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord50BedrijfMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord50BedrijfMySuffix>) => this.onSaveSuccess(),
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
    get record50Bedrijf() {
        return this._record50Bedrijf;
    }

    set record50Bedrijf(record50Bedrijf: IRecord50BedrijfMySuffix) {
        this._record50Bedrijf = record50Bedrijf;
    }
}
