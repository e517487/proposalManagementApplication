import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord35Object } from 'app/shared/model/record-35-object.model';

type EntityResponseType = HttpResponse<IRecord35Object>;
type EntityArrayResponseType = HttpResponse<IRecord35Object[]>;

@Injectable({ providedIn: 'root' })
export class Record35ObjectService {
    private resourceUrl = SERVER_API_URL + 'api/record-35-objects';

    constructor(private http: HttpClient) {}

    create(record35Object: IRecord35Object): Observable<EntityResponseType> {
        return this.http.post<IRecord35Object>(this.resourceUrl, record35Object, { observe: 'response' });
    }

    update(record35Object: IRecord35Object): Observable<EntityResponseType> {
        return this.http.put<IRecord35Object>(this.resourceUrl, record35Object, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord35Object>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord35Object[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
