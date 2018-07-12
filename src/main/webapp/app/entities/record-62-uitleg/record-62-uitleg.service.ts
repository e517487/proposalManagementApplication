import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord62Uitleg } from 'app/shared/model/record-62-uitleg.model';

type EntityResponseType = HttpResponse<IRecord62Uitleg>;
type EntityArrayResponseType = HttpResponse<IRecord62Uitleg[]>;

@Injectable({ providedIn: 'root' })
export class Record62UitlegService {
    private resourceUrl = SERVER_API_URL + 'api/record-62-uitlegs';

    constructor(private http: HttpClient) {}

    create(record62Uitleg: IRecord62Uitleg): Observable<EntityResponseType> {
        return this.http.post<IRecord62Uitleg>(this.resourceUrl, record62Uitleg, { observe: 'response' });
    }

    update(record62Uitleg: IRecord62Uitleg): Observable<EntityResponseType> {
        return this.http.put<IRecord62Uitleg>(this.resourceUrl, record62Uitleg, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord62Uitleg>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord62Uitleg[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
