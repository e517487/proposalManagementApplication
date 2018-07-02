import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';

type EntityResponseType = HttpResponse<IRequestMySuffix>;
type EntityArrayResponseType = HttpResponse<IRequestMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class RequestMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/requests';

    constructor(private http: HttpClient) {}

    create(request: IRequestMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRequestMySuffix>(this.resourceUrl, request, { observe: 'response' });
    }

    update(request: IRequestMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRequestMySuffix>(this.resourceUrl, request, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRequestMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRequestMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
