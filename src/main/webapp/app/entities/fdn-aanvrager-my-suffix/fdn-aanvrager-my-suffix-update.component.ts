import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from './fdn-aanvrager-my-suffix.service';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix';

@Component({
    selector: 'jhi-fdn-aanvrager-my-suffix-update',
    templateUrl: './fdn-aanvrager-my-suffix-update.component.html'
})
export class FdnAanvragerMySuffixUpdateComponent implements OnInit {
    private _fdnAanvrager: IFdnAanvragerMySuffix;
    isSaving: boolean;

    aanvraagberichts: IAanvraagberichtMySuffix[];
    woonachtigHuidigDtDp: any;
    geboorteDtDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ fdnAanvrager }) => {
            this.fdnAanvrager = fdnAanvrager;
        });
        this.aanvraagberichtService.query().subscribe(
            (res: HttpResponse<IAanvraagberichtMySuffix[]>) => {
                this.aanvraagberichts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.fdnAanvrager.id !== undefined) {
            this.subscribeToSaveResponse(this.fdnAanvragerService.update(this.fdnAanvrager));
        } else {
            this.subscribeToSaveResponse(this.fdnAanvragerService.create(this.fdnAanvrager));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IFdnAanvragerMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IFdnAanvragerMySuffix>) => this.onSaveSuccess(),
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

    trackAanvraagberichtById(index: number, item: IAanvraagberichtMySuffix) {
        return item.id;
    }
    get fdnAanvrager() {
        return this._fdnAanvrager;
    }

    set fdnAanvrager(fdnAanvrager: IFdnAanvragerMySuffix) {
        this._fdnAanvrager = fdnAanvrager;
    }
}
