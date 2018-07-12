import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord11AanvraagGegevensOpmerkingenMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord11AanvraagGegevensOpmerkingenMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record11AanvraagGegevensOpmerkingenMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-11-aanvraag-gegevens-opmerkingens';

    constructor(private http: HttpClient) {}

    create(record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingenMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord11AanvraagGegevensOpmerkingenMySuffix>(this.resourceUrl, record11AanvraagGegevensOpmerkingen, {
            observe: 'response'
        });
    }

    update(record11AanvraagGegevensOpmerkingen: IRecord11AanvraagGegevensOpmerkingenMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord11AanvraagGegevensOpmerkingenMySuffix>(this.resourceUrl, record11AanvraagGegevensOpmerkingen, {
            observe: 'response'
        });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord11AanvraagGegevensOpmerkingenMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord11AanvraagGegevensOpmerkingenMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
