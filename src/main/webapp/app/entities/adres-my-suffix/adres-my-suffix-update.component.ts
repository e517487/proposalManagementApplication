import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IAdresMySuffix } from 'app/shared/model/adres-my-suffix.model';
import { AdresMySuffixService } from './adres-my-suffix.service';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix';

@Component({
    selector: 'jhi-adres-my-suffix-update',
    templateUrl: './adres-my-suffix-update.component.html'
})
export class AdresMySuffixUpdateComponent implements OnInit {
    private _adres: IAdresMySuffix;
    isSaving: boolean;

    fdnaanvragers: IFdnAanvragerMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private adresService: AdresMySuffixService,
        private fdnAanvragerService: FdnAanvragerMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ adres }) => {
            this.adres = adres;
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
        if (this.adres.id !== undefined) {
            this.subscribeToSaveResponse(this.adresService.update(this.adres));
        } else {
            this.subscribeToSaveResponse(this.adresService.create(this.adres));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAdresMySuffix>>) {
        result.subscribe((res: HttpResponse<IAdresMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get adres() {
        return this._adres;
    }

    set adres(adres: IAdresMySuffix) {
        this._adres = adres;
    }
}
