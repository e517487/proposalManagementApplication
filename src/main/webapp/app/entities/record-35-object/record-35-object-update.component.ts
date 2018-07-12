import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord35Object } from 'app/shared/model/record-35-object.model';
import { Record35ObjectService } from './record-35-object.service';

@Component({
    selector: 'jhi-record-35-object-update',
    templateUrl: './record-35-object-update.component.html'
})
export class Record35ObjectUpdateComponent implements OnInit {
    private _record35Object: IRecord35Object;
    isSaving: boolean;

    constructor(private record35ObjectService: Record35ObjectService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ record35Object }) => {
            this.record35Object = record35Object;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.record35Object.id !== undefined) {
            this.subscribeToSaveResponse(this.record35ObjectService.update(this.record35Object));
        } else {
            this.subscribeToSaveResponse(this.record35ObjectService.create(this.record35Object));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord35Object>>) {
        result.subscribe((res: HttpResponse<IRecord35Object>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get record35Object() {
        return this._record35Object;
    }

    set record35Object(record35Object: IRecord35Object) {
        this._record35Object = record35Object;
    }
}
