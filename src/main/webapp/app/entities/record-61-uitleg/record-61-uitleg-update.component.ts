import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord61Uitleg } from 'app/shared/model/record-61-uitleg.model';
import { Record61UitlegService } from './record-61-uitleg.service';

@Component({
    selector: 'jhi-record-61-uitleg-update',
    templateUrl: './record-61-uitleg-update.component.html'
})
export class Record61UitlegUpdateComponent implements OnInit {
    private _record61Uitleg: IRecord61Uitleg;
    isSaving: boolean;

    constructor(private record61UitlegService: Record61UitlegService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record61Uitleg }) => {
            this.record61Uitleg = record61Uitleg;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record61Uitleg.id !== undefined) {
            this.subscribeToSaveResponse(this.record61UitlegService.update(this.record61Uitleg));
        } else {
            this.subscribeToSaveResponse(this.record61UitlegService.create(this.record61Uitleg));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord61Uitleg>>) {
        result.subscribe((res: HttpResponse<IRecord61Uitleg>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get record61Uitleg() {
        return this._record61Uitleg;
    }

    set record61Uitleg(record61Uitleg: IRecord61Uitleg) {
        this._record61Uitleg = record61Uitleg;
    }
}
