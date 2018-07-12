import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';

type EntityResponseType = HttpResponse<IRecord10AanvraagGegevensAlgemeen>;
type EntityArrayResponseType = HttpResponse<IRecord10AanvraagGegevensAlgemeen[]>;

@Injectable({ providedIn: 'root' })
export class Record10AanvraagGegevensAlgemeenService {
    private resourceUrl = SERVER_API_URL + 'api/record-10-aanvraag-gegevens-algemeens';

    constructor(private http: HttpClient) {}

    create(record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record10AanvraagGegevensAlgemeen);
        return this.http
            .post<IRecord10AanvraagGegevensAlgemeen>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    update(record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(record10AanvraagGegevensAlgemeen);
        return this.http
            .put<IRecord10AanvraagGegevensAlgemeen>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IRecord10AanvraagGegevensAlgemeen>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertDateFromServer(res));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IRecord10AanvraagGegevensAlgemeen[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen): IRecord10AanvraagGegevensAlgemeen {
        const copy: IRecord10AanvraagGegevensAlgemeen = Object.assign({}, record10AanvraagGegevensAlgemeen, {
            aanvangDatum:
                record10AanvraagGegevensAlgemeen.aanvangDatum != null && record10AanvraagGegevensAlgemeen.aanvangDatum.isValid()
                    ? record10AanvraagGegevensAlgemeen.aanvangDatum.format(DATE_FORMAT)
                    : null,
            aanvangTijd:
                record10AanvraagGegevensAlgemeen.aanvangTijd != null && record10AanvraagGegevensAlgemeen.aanvangTijd.isValid()
                    ? record10AanvraagGegevensAlgemeen.aanvangTijd.toJSON()
                    : null,
            acceptatieDatum:
                record10AanvraagGegevensAlgemeen.acceptatieDatum != null && record10AanvraagGegevensAlgemeen.acceptatieDatum.isValid()
                    ? record10AanvraagGegevensAlgemeen.acceptatieDatum.format(DATE_FORMAT)
                    : null,
            acceptatieTijd:
                record10AanvraagGegevensAlgemeen.acceptatieTijd != null && record10AanvraagGegevensAlgemeen.acceptatieTijd.isValid()
                    ? record10AanvraagGegevensAlgemeen.acceptatieTijd.toJSON()
                    : null,
            prtDatum:
                record10AanvraagGegevensAlgemeen.prtDatum != null && record10AanvraagGegevensAlgemeen.prtDatum.isValid()
                    ? record10AanvraagGegevensAlgemeen.prtDatum.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.aanvangDatum = res.body.aanvangDatum != null ? moment(res.body.aanvangDatum) : null;
        res.body.aanvangTijd = res.body.aanvangTijd != null ? moment(res.body.aanvangTijd) : null;
        res.body.acceptatieDatum = res.body.acceptatieDatum != null ? moment(res.body.acceptatieDatum) : null;
        res.body.acceptatieTijd = res.body.acceptatieTijd != null ? moment(res.body.acceptatieTijd) : null;
        res.body.prtDatum = res.body.prtDatum != null ? moment(res.body.prtDatum) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((record10AanvraagGegevensAlgemeen: IRecord10AanvraagGegevensAlgemeen) => {
            record10AanvraagGegevensAlgemeen.aanvangDatum =
                record10AanvraagGegevensAlgemeen.aanvangDatum != null ? moment(record10AanvraagGegevensAlgemeen.aanvangDatum) : null;
            record10AanvraagGegevensAlgemeen.aanvangTijd =
                record10AanvraagGegevensAlgemeen.aanvangTijd != null ? moment(record10AanvraagGegevensAlgemeen.aanvangTijd) : null;
            record10AanvraagGegevensAlgemeen.acceptatieDatum =
                record10AanvraagGegevensAlgemeen.acceptatieDatum != null ? moment(record10AanvraagGegevensAlgemeen.acceptatieDatum) : null;
            record10AanvraagGegevensAlgemeen.acceptatieTijd =
                record10AanvraagGegevensAlgemeen.acceptatieTijd != null ? moment(record10AanvraagGegevensAlgemeen.acceptatieTijd) : null;
            record10AanvraagGegevensAlgemeen.prtDatum =
                record10AanvraagGegevensAlgemeen.prtDatum != null ? moment(record10AanvraagGegevensAlgemeen.prtDatum) : null;
        });
        return res;
    }
}
