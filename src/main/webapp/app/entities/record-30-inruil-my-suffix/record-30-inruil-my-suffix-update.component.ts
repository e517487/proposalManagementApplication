import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';
import { Record30InruilMySuffixService } from './record-30-inruil-my-suffix.service';

@Component({
    selector: 'jhi-record-30-inruil-my-suffix-update',
    templateUrl: './record-30-inruil-my-suffix-update.component.html'
})
export class Record30InruilMySuffixUpdateComponent implements OnInit {
    private _record30Inruil: IRecord30InruilMySuffix;
    isSaving: boolean;

    constructor(private record30InruilService: Record30InruilMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record30Inruil }) => {
            this.record30Inruil = record30Inruil;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record30Inruil.id !== undefined) {
            this.subscribeToSaveResponse(this.record30InruilService.update(this.record30Inruil));
        } else {
            this.subscribeToSaveResponse(this.record30InruilService.create(this.record30Inruil));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord30InruilMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord30InruilMySuffix>) => this.onSaveSuccess(),
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
    get record30Inruil() {
        return this._record30Inruil;
    }

    set record30Inruil(record30Inruil: IRecord30InruilMySuffix) {
        this._record30Inruil = record30Inruil;
    }
}
