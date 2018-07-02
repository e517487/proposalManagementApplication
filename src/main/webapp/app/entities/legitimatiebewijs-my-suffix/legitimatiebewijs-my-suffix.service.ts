import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ILegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';

type EntityResponseType = HttpResponse<ILegitimatiebewijsMySuffix>;
type EntityArrayResponseType = HttpResponse<ILegitimatiebewijsMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class LegitimatiebewijsMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/legitimatiebewijs';

    constructor(private http: HttpClient) {}

    create(legitimatiebewijs: ILegitimatiebewijsMySuffix): Observable<EntityResponseType> {
        return this.http.post<ILegitimatiebewijsMySuffix>(this.resourceUrl, legitimatiebewijs, { observe: 'response' });
    }

    update(legitimatiebewijs: ILegitimatiebewijsMySuffix): Observable<EntityResponseType> {
        return this.http.put<ILegitimatiebewijsMySuffix>(this.resourceUrl, legitimatiebewijs, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ILegitimatiebewijsMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ILegitimatiebewijsMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
