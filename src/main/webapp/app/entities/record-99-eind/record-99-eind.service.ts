import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord99Eind } from 'app/shared/model/record-99-eind.model';

type EntityResponseType = HttpResponse<IRecord99Eind>;
type EntityArrayResponseType = HttpResponse<IRecord99Eind[]>;

@Injectable({ providedIn: 'root' })
export class Record99EindService {
    private resourceUrl = SERVER_API_URL + 'api/record-99-einds';

    constructor(private http: HttpClient) {}

    create(record99Eind: IRecord99Eind): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record99Eind);
        return this.http
            .post<IRecord99Eind>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(record99Eind: IRecord99Eind): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record99Eind);
        return this.http
            .put<IRecord99Eind>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IRecord99Eind>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IRecord99Eind[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(record99Eind: IRecord99Eind): IRecord99Eind {
        const copy: IRecord99Eind = Object.assign({}, record99Eind, {
            creatieDatum:
                record99Eind.creatieDatum != null && record99Eind.creatieDatum.isValid()
                    ? record99Eind.creatieDatum.format(DATE_FORMAT)
                    : null,
            creatieTijd: record99Eind.creatieTijd != null && record99Eind.creatieTijd.isValid() ? record99Eind.creatieTijd.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.creatieDatum = res.body.creatieDatum != null ? moment(res.body.creatieDatum) : null;
        res.body.creatieTijd = res.body.creatieTijd != null ? moment(res.body.creatieTijd) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((record99Eind: IRecord99Eind) => {
            record99Eind.creatieDatum = record99Eind.creatieDatum != null ? moment(record99Eind.creatieDatum) : null;
            record99Eind.creatieTijd = record99Eind.creatieTijd != null ? moment(record99Eind.creatieTijd) : null;
        });
        return res;
    }
}
