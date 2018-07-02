import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from './aanvraagbericht-my-suffix.service';
import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';
import { RekenmoduleAanvraagMySuffixService } from 'app/entities/rekenmodule-aanvraag-my-suffix';
import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';
import { HeaderMySuffixService } from 'app/entities/header-my-suffix';
import { IAlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';
import { AlgemeenMySuffixService } from 'app/entities/algemeen-my-suffix';

@Component({
    selector: 'jhi-aanvraagbericht-my-suffix-update',
    templateUrl: './aanvraagbericht-my-suffix-update.component.html'
})
export class AanvraagberichtMySuffixUpdateComponent implements OnInit {
    private _aanvraagbericht: IAanvraagberichtMySuffix;
    isSaving: boolean;

    rekenmoduleaanvraags: IRekenmoduleAanvraagMySuffix[];

    headers: IHeaderMySuffix[];

    algemeens: IAlgemeenMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private rekenmoduleAanvraagService: RekenmoduleAanvraagMySuffixService,
        private headerService: HeaderMySuffixService,
        private algemeenService: AlgemeenMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ aanvraagbericht }) => {
            this.aanvraagbericht = aanvraagbericht;
        });
        this.rekenmoduleAanvraagService.query({ filter: 'aanvraagbericht-is-null' }).subscribe(
            (res: HttpResponse<IRekenmoduleAanvraagMySuffix[]>) => {
                if (!this.aanvraagbericht.rekenmoduleAanvraagId) {
                    this.rekenmoduleaanvraags = res.body;
                } else {
                    this.rekenmoduleAanvraagService.find(this.aanvraagbericht.rekenmoduleAanvraagId).subscribe(
                        (subRes: HttpResponse<IRekenmoduleAanvraagMySuffix>) => {
                            this.rekenmoduleaanvraags = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.headerService.query({ filter: 'aanvraagbericht-is-null' }).subscribe(
            (res: HttpResponse<IHeaderMySuffix[]>) => {
                if (!this.aanvraagbericht.headerId) {
                    this.headers = res.body;
                } else {
                    this.headerService.find(this.aanvraagbericht.headerId).subscribe(
                        (subRes: HttpResponse<IHeaderMySuffix>) => {
                            this.headers = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.algemeenService.query({ filter: 'aanvraagbericht-is-null' }).subscribe(
            (res: HttpResponse<IAlgemeenMySuffix[]>) => {
                if (!this.aanvraagbericht.algemeenId) {
                    this.algemeens = res.body;
                } else {
                    this.algemeenService.find(this.aanvraagbericht.algemeenId).subscribe(
                        (subRes: HttpResponse<IAlgemeenMySuffix>) => {
                            this.algemeens = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.aanvraagbericht.id !== undefined) {
            this.subscribeToSaveResponse(this.aanvraagberichtService.update(this.aanvraagbericht));
        } else {
            this.subscribeToSaveResponse(this.aanvraagberichtService.create(this.aanvraagbericht));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAanvraagberichtMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IAanvraagberichtMySuffix>) => this.onSaveSuccess(),
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

    trackRekenmoduleAanvraagById(index: number, item: IRekenmoduleAanvraagMySuffix) {
        return item.id;
    }

    trackHeaderById(index: number, item: IHeaderMySuffix) {
        return item.id;
    }

    trackAlgemeenById(index: number, item: IAlgemeenMySuffix) {
        return item.id;
    }
    get aanvraagbericht() {
        return this._aanvraagbericht;
    }

    set aanvraagbericht(aanvraagbericht: IAanvraagberichtMySuffix) {
        this._aanvraagbericht = aanvraagbericht;
    }
}
