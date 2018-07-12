import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord63Uitleg } from 'app/shared/model/record-63-uitleg.model';

type EntityResponseType = HttpResponse<IRecord63Uitleg>;
type EntityArrayResponseType = HttpResponse<IRecord63Uitleg[]>;

@Injectable({ providedIn: 'root' })
export class Record63UitlegService {
    private resourceUrl = SERVER_API_URL + 'api/record-63-uitlegs';

    constructor(private http: HttpClient) {}

    create(record63Uitleg: IRecord63Uitleg): Observable<EntityResponseType> {
        return this.http.post<IRecord63Uitleg>(this.resourceUrl, record63Uitleg, { observe: 'response' });
    }

    update(record63Uitleg: IRecord63Uitleg): Observable<EntityResponseType> {
        return this.http.put<IRecord63Uitleg>(this.resourceUrl, record63Uitleg, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord63Uitleg>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord63Uitleg[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
