import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';
import { RekenmoduleAanvraagMySuffixService } from './rekenmodule-aanvraag-my-suffix.service';
import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';
import { RequestMySuffixService } from 'app/entities/request-my-suffix';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix';

@Component({
    selector: 'jhi-rekenmodule-aanvraag-my-suffix-update',
    templateUrl: './rekenmodule-aanvraag-my-suffix-update.component.html'
})
export class RekenmoduleAanvraagMySuffixUpdateComponent implements OnInit {
    private _rekenmoduleAanvraag: IRekenmoduleAanvraagMySuffix;
    isSaving: boolean;

    requests: IRequestMySuffix[];

    aanvraagberichts: IAanvraagberichtMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private rekenmoduleAanvraagService: RekenmoduleAanvraagMySuffixService,
        private requestService: RequestMySuffixService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ rekenmoduleAanvraag }) => {
            this.rekenmoduleAanvraag = rekenmoduleAanvraag;
        });
        this.requestService.query({ filter: 'rekenmoduleaanvraag-is-null' }).subscribe(
            (res: HttpResponse<IRequestMySuffix[]>) => {
                if (!this.rekenmoduleAanvraag.requestId) {
                    this.requests = res.body;
                } else {
                    this.requestService.find(this.rekenmoduleAanvraag.requestId).subscribe(
                        (subRes: HttpResponse<IRequestMySuffix>) => {
                            this.requests = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
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
        if (this.rekenmoduleAanvraag.id !== undefined) {
            this.subscribeToSaveResponse(this.rekenmoduleAanvraagService.update(this.rekenmoduleAanvraag));
        } else {
            this.subscribeToSaveResponse(this.rekenmoduleAanvraagService.create(this.rekenmoduleAanvraag));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IRekenmoduleAanvraagMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IRekenmoduleAanvraagMySuffix>) => this.onSaveSuccess(),
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

    trackRequestById(index: number, item: IRequestMySuffix) {
        return item.id;
    }

    trackAanvraagberichtById(index: number, item: IAanvraagberichtMySuffix) {
        return item.id;
    }
    get rekenmoduleAanvraag() {
        return this._rekenmoduleAanvraag;
    }

    set rekenmoduleAanvraag(rekenmoduleAanvraag: IRekenmoduleAanvraagMySuffix) {
        this._rekenmoduleAanvraag = rekenmoduleAanvraag;
    }
}
