import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';

type EntityResponseType = HttpResponse<IHeaderMySuffix>;
type EntityArrayResponseType = HttpResponse<IHeaderMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class HeaderMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/headers';

    constructor(private http: HttpClient) {}

    create(header: IHeaderMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(header);
        return this.http
            .post<IHeaderMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(header: IHeaderMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(header);
        return this.http
            .put<IHeaderMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IHeaderMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IHeaderMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(header: IHeaderMySuffix): IHeaderMySuffix {
        const copy: IHeaderMySuffix = Object.assign({}, header, {
            verzendDt: header.verzendDt != null && header.verzendDt.isValid() ? header.verzendDt.format(DATE_FORMAT) : null,
            verzendTijd: header.verzendTijd != null && header.verzendTijd.isValid() ? header.verzendTijd.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.verzendDt = res.body.verzendDt != null ? moment(res.body.verzendDt) : null;
        res.body.verzendTijd = res.body.verzendTijd != null ? moment(res.body.verzendTijd) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((header: IHeaderMySuffix) => {
            header.verzendDt = header.verzendDt != null ? moment(header.verzendDt) : null;
            header.verzendTijd = header.verzendTijd != null ? moment(header.verzendTijd) : null;
        });
        return res;
    }
}
