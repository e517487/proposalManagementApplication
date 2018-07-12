import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord01StartMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord01StartMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record01StartMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-01-starts';

    constructor(private http: HttpClient) {}

    create(record01Start: IRecord01StartMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record01Start);
        return this.http
            .post<IRecord01StartMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(record01Start: IRecord01StartMySuffix): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record01Start);
        return this.http
            .put<IRecord01StartMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IRecord01StartMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IRecord01StartMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(record01Start: IRecord01StartMySuffix): IRecord01StartMySuffix {
        const copy: IRecord01StartMySuffix = Object.assign({}, record01Start, {
            creatieDatum:
                record01Start.creatieDatum != null && record01Start.creatieDatum.isValid()
                    ? record01Start.creatieDatum.format(DATE_FORMAT)
                    : null,
            creatieTijd:
                record01Start.creatieTijd != null && record01Start.creatieTijd.isValid() ? record01Start.creatieTijd.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.creatieDatum = res.body.creatieDatum != null ? moment(res.body.creatieDatum) : null;
        res.body.creatieTijd = res.body.creatieTijd != null ? moment(res.body.creatieTijd) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((record01Start: IRecord01StartMySuffix) => {
            record01Start.creatieDatum = record01Start.creatieDatum != null ? moment(record01Start.creatieDatum) : null;
            record01Start.creatieTijd = record01Start.creatieTijd != null ? moment(record01Start.creatieTijd) : null;
        });
        return res;
    }
}
