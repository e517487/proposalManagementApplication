import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord99EndMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord99EndMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record99EndMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-99-ends';

    constructor(private http: HttpClient) {}

    create(record99End: IRecord99EndMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record99End);
        return this.http
            .post<IRecord99EndMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(record99End: IRecord99EndMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record99End);
        return this.http
            .put<IRecord99EndMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IRecord99EndMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IRecord99EndMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(record99End: IRecord99EndMySuffix): IRecord99EndMySuffix {
        const copy: IRecord99EndMySuffix = Object.assign({}, record99End, {
            creatieDatum:
                record99End.creatieDatum != null && record99End.creatieDatum.isValid()
                    ? record99End.creatieDatum.format(DATE_FORMAT)
                    : null,
            creatieTijd: record99End.creatieTijd != null && record99End.creatieTijd.isValid() ? record99End.creatieTijd.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.creatieDatum = res.body.creatieDatum != null ? moment(res.body.creatieDatum) : null;
        res.body.creatieTijd = res.body.creatieTijd != null ? moment(res.body.creatieTijd) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((record99End: IRecord99EndMySuffix) => {
            record99End.creatieDatum = record99End.creatieDatum != null ? moment(record99End.creatieDatum) : null;
            record99End.creatieTijd = record99End.creatieTijd != null ? moment(record99End.creatieTijd) : null;
        });
        return res;
    }
}
