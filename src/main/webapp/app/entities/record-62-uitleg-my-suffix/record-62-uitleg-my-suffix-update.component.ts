import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';
import { Record62UitlegMySuffixService } from './record-62-uitleg-my-suffix.service';

@Component({
    selector: 'jhi-record-62-uitleg-my-suffix-update',
    templateUrl: './record-62-uitleg-my-suffix-update.component.html'
})
export class Record62UitlegMySuffixUpdateComponent implements OnInit {
    private _record62Uitleg: IRecord62UitlegMySuffix;
    isSaving: boolean;

    constructor(private record62UitlegService: Record62UitlegMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record62Uitleg }) => {
            this.record62Uitleg = record62Uitleg;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record62Uitleg.id !== undefined) {
            this.subscribeToSaveResponse(this.record62UitlegService.update(this.record62Uitleg));
        } else {
            this.subscribeToSaveResponse(this.record62UitlegService.create(this.record62Uitleg));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord62UitlegMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord62UitlegMySuffix>) => this.onSaveSuccess(),
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
    get record62Uitleg() {
        return this._record62Uitleg;
    }

    set record62Uitleg(record62Uitleg: IRecord62UitlegMySuffix) {
        this._record62Uitleg = record62Uitleg;
    }
}
