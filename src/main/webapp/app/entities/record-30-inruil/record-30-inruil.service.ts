import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord30Inruil } from 'app/shared/model/record-30-inruil.model';

type EntityResponseType = HttpResponse<IRecord30Inruil>;
type EntityArrayResponseType = HttpResponse<IRecord30Inruil[]>;

@Injectable({ providedIn: 'root' })
export class Record30InruilService {
    private resourceUrl = SERVER_API_URL + 'api/record-30-inruils';

    constructor(private http: HttpClient) {}

    create(record30Inruil: IRecord30Inruil): Observable<EntityResponseType> {
        return this.http.post<IRecord30Inruil>(this.resourceUrl, record30Inruil, { observe: 'response' });
    }

    update(record30Inruil: IRecord30Inruil): Observable<EntityResponseType> {
        return this.http.put<IRecord30Inruil>(this.resourceUrl, record30Inruil, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord30Inruil>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord30Inruil[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
