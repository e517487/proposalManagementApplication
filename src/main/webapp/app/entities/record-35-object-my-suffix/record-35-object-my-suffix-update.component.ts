import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IRecord35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';
import { Record35ObjectMySuffixService } from './record-35-object-my-suffix.service';

@Component({
    selector: 'jhi-record-35-object-my-suffix-update',
    templateUrl: './record-35-object-my-suffix-update.component.html'
})
export class Record35ObjectMySuffixUpdateComponent implements OnInit {
    private _record35Object: IRecord35ObjectMySuffix;
    isSaving: boolean;

    constructor(private record35ObjectService: Record35ObjectMySuffixService, private activatedRoute: ActivatedRoute) {}

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

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRecord35ObjectMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRecord35ObjectMySuffix>) => this.onSaveSuccess(),
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
    get record35Object() {
        return this._record35Object;
    }

    set record35Object(record35Object: IRecord35ObjectMySuffix) {
        this._record35Object = record35Object;
    }
}
