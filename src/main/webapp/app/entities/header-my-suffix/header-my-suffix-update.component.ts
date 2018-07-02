import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';
import { HeaderMySuffixService } from './header-my-suffix.service';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix';

@Component({
    selector: 'jhi-header-my-suffix-update',
    templateUrl: './header-my-suffix-update.component.html'
})
export class HeaderMySuffixUpdateComponent implements OnInit {
    private _header: IHeaderMySuffix;
    isSaving: boolean;

    aanvraagberichts: IAanvraagberichtMySuffix[];
    verzendDtDp: any;
    verzendTijdDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private headerService: HeaderMySuffixService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ header }) => {
            this.header = header;
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
        if (this.header.id !== undefined) {
            this.subscribeToSaveResponse(this.headerService.update(this.header));
        } else {
            this.subscribeToSaveResponse(this.headerService.create(this.header));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IHeaderMySuffix>>) {
        result.subscribe((res: HttpResponse<IHeaderMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get header() {
        return this._header;
    }

    set header(header: IHeaderMySuffix) {
        this._header = header;
    }
}
