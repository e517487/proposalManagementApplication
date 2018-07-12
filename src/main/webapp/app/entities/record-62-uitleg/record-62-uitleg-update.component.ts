import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord62Uitleg } from 'app/shared/model/record-62-uitleg.model';
import { Record62UitlegService } from './record-62-uitleg.service';

@Component({
    selector: 'jhi-record-62-uitleg-update',
    templateUrl: './record-62-uitleg-update.component.html'
})
export class Record62UitlegUpdateComponent implements OnInit {
    private _record62Uitleg: IRecord62Uitleg;
    isSaving: boolean;

    constructor(private record62UitlegService: Record62UitlegService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord62Uitleg>>) {
        result.subscribe((res: HttpResponse<IRecord62Uitleg>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    set record62Uitleg(record62Uitleg: IRecord62Uitleg) {
        this._record62Uitleg = record62Uitleg;
    }
}
