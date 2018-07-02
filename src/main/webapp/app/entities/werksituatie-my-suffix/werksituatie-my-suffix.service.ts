import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';

type EntityResponseType = HttpResponse<IWerksituatieMySuffix>;
type EntityArrayResponseType = HttpResponse<IWerksituatieMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class WerksituatieMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/werksituaties';

    constructor(private http: HttpClient) {}

    create(werksituatie: IWerksituatieMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(werksituatie);
        return this.http
            .post<IWerksituatieMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(werksituatie: IWerksituatieMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(werksituatie);
        return this.http
            .put<IWerksituatieMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IWerksituatieMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IWerksituatieMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(werksituatie: IWerksituatieMySuffix): IWerksituatieMySuffix {
        const copy: IWerksituatieMySuffix = Object.assign({}, werksituatie, {
            beginDienstverbandDt:
                werksituatie.beginDienstverbandDt != null && werksituatie.beginDienstverbandDt.isValid()
                    ? werksituatie.beginDienstverbandDt.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.beginDienstverbandDt = res.body.beginDienstverbandDt != null ? moment(res.body.beginDienstverbandDt) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((werksituatie: IWerksituatieMySuffix) => {
            werksituatie.beginDienstverbandDt =
                werksituatie.beginDienstverbandDt != null ? moment(werksituatie.beginDienstverbandDt) : null;
        });
        return res;
    }
}
