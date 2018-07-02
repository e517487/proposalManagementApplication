import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IAlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';
import { AlgemeenMySuffixService } from './algemeen-my-suffix.service';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix';

@Component({
    selector: 'jhi-algemeen-my-suffix-update',
    templateUrl: './algemeen-my-suffix-update.component.html'
})
export class AlgemeenMySuffixUpdateComponent implements OnInit {
    private _algemeen: IAlgemeenMySuffix;
    isSaving: boolean;

    aanvraagberichts: IAanvraagberichtMySuffix[];
    registratieDtDp: any;

    constructor(
        private jhiAlertService: JhiAlertService,
        private algemeenService: AlgemeenMySuffixService,
        private aanvraagberichtService: AanvraagberichtMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ algemeen }) => {
            this.algemeen = algemeen;
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
        if (this.algemeen.id !== undefined) {
            this.subscribeToSaveResponse(this.algemeenService.update(this.algemeen));
        } else {
            this.subscribeToSaveResponse(this.algemeenService.create(this.algemeen));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IAlgemeenMySuffix>>) {
        result.subscribe((res: HttpResponse<IAlgemeenMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
    get algemeen() {
        return this._algemeen;
    }

    set algemeen(algemeen: IAlgemeenMySuffix) {
        this._algemeen = algemeen;
    }
}
