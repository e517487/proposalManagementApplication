import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IKredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';
import { KredietAanvraagMySuffixService } from './krediet-aanvraag-my-suffix.service';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix';

@Component({
    selector: 'jhi-krediet-aanvraag-my-suffix-update',
    templateUrl: './krediet-aanvraag-my-suffix-update.component.html'
})
export class KredietAanvraagMySuffixUpdateComponent implements OnInit {
    private _kredietAanvraag: IKredietAanvraagMySuffix;
    isSaving: boolean;

    aanvraagberichts: IAanvraagberichtMySuffix[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private kredietAanvraagService: KredietAanvraagMySuffixService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ kredietAanvraag }) => {
            this.kredietAanvraag = kredietAanvraag;
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
        if (this.kredietAanvraag.id !== undefined) {
            this.subscribeToSaveResponse(this.kredietAanvraagService.update(this.kredietAanvraag));
        } else {
            this.subscribeToSaveResponse(this.kredietAanvraagService.create(this.kredietAanvraag));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IKredietAanvraagMySuffix>>) {
        result.subscribe(
            (res: HttpResponse<IKredietAanvraagMySuffix>) => this.onSaveSuccess(),
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
    get kredietAanvraag() {
        return this._kredietAanvraag;
    }

    set kredietAanvraag(kredietAanvraag: IKredietAanvraagMySuffix) {
        this._kredietAanvraag = kredietAanvraag;
    }
}
