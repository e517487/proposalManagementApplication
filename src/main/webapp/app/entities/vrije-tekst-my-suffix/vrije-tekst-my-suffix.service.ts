import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';

type EntityResponseType = HttpResponse<IVrijeTekstMySuffix>;
type EntityArrayResponseType = HttpResponse<IVrijeTekstMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class VrijeTekstMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/vrije-teksts';

    constructor(private http: HttpClient) {}

    create(vrijeTekst: IVrijeTekstMySuffix): Observable<EntityResponseType> {
        return this.http.post<IVrijeTekstMySuffix>(this.resourceUrl, vrijeTekst, { observe: 'response' });
    }

    update(vrijeTekst: IVrijeTekstMySuffix): Observable<EntityResponseType> {
        return this.http.put<IVrijeTekstMySuffix>(this.resourceUrl, vrijeTekst, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IVrijeTekstMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IVrijeTekstMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
