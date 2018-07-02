import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';

type EntityResponseType = HttpResponse<IAlgemeenMySuffix>;
type EntityArrayResponseType = HttpResponse<IAlgemeenMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class AlgemeenMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/algemeens';

    constructor(private http: HttpClient) {}

    create(algemeen: IAlgemeenMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(algemeen);
        return this.http
            .post<IAlgemeenMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(algemeen: IAlgemeenMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(algemeen);
        return this.http
            .put<IAlgemeenMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IAlgemeenMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IAlgemeenMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(algemeen: IAlgemeenMySuffix): IAlgemeenMySuffix {
        const copy: IAlgemeenMySuffix = Object.assign({}, algemeen, {
            registratieDt:
                algemeen.registratieDt != null && algemeen.registratieDt.isValid() ? algemeen.registratieDt.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.registratieDt = res.body.registratieDt != null ? moment(res.body.registratieDt) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((algemeen: IAlgemeenMySuffix) => {
            algemeen.registratieDt = algemeen.registratieDt != null ? moment(algemeen.registratieDt) : null;
        });
        return res;
    }
}
