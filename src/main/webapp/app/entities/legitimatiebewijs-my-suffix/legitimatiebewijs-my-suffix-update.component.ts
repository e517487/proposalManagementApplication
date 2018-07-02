import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ILegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';
import { LegitimatiebewijsMySuffixService } from './legitimatiebewijs-my-suffix.service';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix';

@Component({
    selector: 'jhi-legitimatiebewijs-my-suffix-update',
    templateUrl: './legitimatiebewijs-my-suffix-update.component.html'
})
export class LegitimatiebewijsMySuffixUpdateComponent implements OnInit {
    private _legitimatiebewijs: ILegitimatiebewijsMySuffix;
    isSaving: boolean;

    fdnaanvragers: IFdnAanvragerMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private legitimatiebewijsService: LegitimatiebewijsMySuffixService,
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ legitimatiebewijs }) => {
            this.legitimatiebewijs = legitimatiebewijs;
        });
        this.fdnAanvragerService.query().subscribe(
            (res: HttpResponse<IFdnAanvragerMySuffix[]>) => {
                this.fdnaanvragers = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.legitimatiebewijs.id !== undefined) {
            this.subscribeToSaveResponse(this.legitimatiebewijsService.update(this.legitimatiebewijs));
        } else {
            this.subscribeToSaveResponse(this.legitimatiebewijsService.create(this.legitimatiebewijs));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ILegitimatiebewijsMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<ILegitimatiebewijsMySuffix>) => this.onSaveSuccess(),
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

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackFdnAanvragerById(index: number, item: IFdnAanvragerMySuffix) {
        return item.id;
    }
    get legitimatiebewijs() {
        return this._legitimatiebewijs;
    }

    set legitimatiebewijs(legitimatiebewijs: ILegitimatiebewijsMySuffix) {
        this._legitimatiebewijs = legitimatiebewijs;
    }
}
