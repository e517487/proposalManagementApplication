import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord35ObjectMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord35ObjectMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record35ObjectMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-35-objects';

    constructor(private http: HttpClient) {}

    create(record35Object: IRecord35ObjectMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord35ObjectMySuffix>(this.resourceUrl, record35Object, { observe: 'response' });
    }

    update(record35Object: IRecord35ObjectMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord35ObjectMySuffix>(this.resourceUrl, record35Object, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord35ObjectMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord35ObjectMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
