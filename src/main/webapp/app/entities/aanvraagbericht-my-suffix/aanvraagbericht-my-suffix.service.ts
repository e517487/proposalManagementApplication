import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';

type EntityResponseType = HttpResponse<IAanvraagberichtMySuffix>;
type EntityArrayResponseType = HttpResponse<IAanvraagberichtMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class AanvraagberichtMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/aanvraagberichts';

    constructor(private http: HttpClient) {}

    create(aanvraagbericht: IAanvraagberichtMySuffix): Observable<EntityResponseType> {
        return this.http.post<IAanvraagberichtMySuffix>(this.resourceUrl, aanvraagbericht, { observe: 'response' });
    }

    update(aanvraagbericht: IAanvraagberichtMySuffix): Observable<EntityResponseType> {
        return this.http.put<IAanvraagberichtMySuffix>(this.resourceUrl, aanvraagbericht, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IAanvraagberichtMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IAanvraagberichtMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
