import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord30Inruil } from 'app/shared/model/record-30-inruil.model';
import { Record30InruilService } from './record-30-inruil.service';

@Component({
    selector: 'jhi-record-30-inruil-update',
    templateUrl: './record-30-inruil-update.component.html'
})
export class Record30InruilUpdateComponent implements OnInit {
    private _record30Inruil: IRecord30Inruil;
    isSaving: boolean;

    constructor(private record30InruilService: Record30InruilService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord30Inruil>>) {
        result.subscribe((res: HttpResponse<IRecord30Inruil>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    set record30Inruil(record30Inruil: IRecord30Inruil) {
        this._record30Inruil = record30Inruil;
    }
}
