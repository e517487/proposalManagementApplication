import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';

type EntityResponseType = HttpResponse<IFdnAanvragerMySuffix>;
type EntityArrayResponseType = HttpResponse<IFdnAanvragerMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class FdnAanvragerMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/fdn-aanvragers';

    constructor(private http: HttpClient) {}

    create(fdnAanvrager: IFdnAanvragerMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(fdnAanvrager);
        return this.http
            .post<IFdnAanvragerMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(fdnAanvrager: IFdnAanvragerMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(fdnAanvrager);
        return this.http
            .put<IFdnAanvragerMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IFdnAanvragerMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IFdnAanvragerMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(fdnAanvrager: IFdnAanvragerMySuffix): IFdnAanvragerMySuffix {
        const copy: IFdnAanvragerMySuffix = Object.assign({}, fdnAanvrager, {
            woonachtigHuidigDt:
                fdnAanvrager.woonachtigHuidigDt != null && fdnAanvrager.woonachtigHuidigDt.isValid()
                    ? fdnAanvrager.woonachtigHuidigDt.format(DATE_FORMAT)
                    : null,
            geboorteDt:
                fdnAanvrager.geboorteDt != null && fdnAanvrager.geboorteDt.isValid() ? fdnAanvrager.geboorteDt.format(DATE_FORMAT) : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.woonachtigHuidigDt = res.body.woonachtigHuidigDt != null ? moment(res.body.woonachtigHuidigDt) : null;
        res.body.geboorteDt = res.body.geboorteDt != null ? moment(res.body.geboorteDt) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((fdnAanvrager: IFdnAanvragerMySuffix) => {
            fdnAanvrager.woonachtigHuidigDt = fdnAanvrager.woonachtigHuidigDt != null ? moment(fdnAanvrager.woonachtigHuidigDt) : null;
            fdnAanvrager.geboorteDt = fdnAanvrager.geboorteDt != null ? moment(fdnAanvrager.geboorteDt) : null;
        });
        return res;
    }
}
