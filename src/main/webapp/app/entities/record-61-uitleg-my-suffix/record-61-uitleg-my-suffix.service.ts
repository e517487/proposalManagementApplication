import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord61UitlegMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord61UitlegMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record61UitlegMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-61-uitlegs';

    constructor(private http: HttpClient) {}

    create(record61Uitleg: IRecord61UitlegMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord61UitlegMySuffix>(this.resourceUrl, record61Uitleg, { observe: 'response' });
    }

    update(record61Uitleg: IRecord61UitlegMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord61UitlegMySuffix>(this.resourceUrl, record61Uitleg, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord61UitlegMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord61UitlegMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
