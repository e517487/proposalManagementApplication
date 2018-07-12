import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';
import { Record63UitlegMySuffixService } from './record-63-uitleg-my-suffix.service';

@Component({
    selector: 'jhi-record-63-uitleg-my-suffix-update',
    templateUrl: './record-63-uitleg-my-suffix-update.component.html'
})
export class Record63UitlegMySuffixUpdateComponent implements OnInit {
    private _record63Uitleg: IRecord63UitlegMySuffix;
    isSaving: boolean;

    constructor(private record63UitlegService: Record63UitlegMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record63Uitleg }) => {
            this.record63Uitleg = record63Uitleg;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record63Uitleg.id !== undefined) {
            this.subscribeToSaveResponse(this.record63UitlegService.update(this.record63Uitleg));
        } else {
            this.subscribeToSaveResponse(this.record63UitlegService.create(this.record63Uitleg));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord63UitlegMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord63UitlegMySuffix>) => this.onSaveSuccess(),
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
    get record63Uitleg() {
        return this._record63Uitleg;
    }

    set record63Uitleg(record63Uitleg: IRecord63UitlegMySuffix) {
        this._record63Uitleg = record63Uitleg;
    }
}
