import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IAdresMySuffix } from 'app/shared/model/adres-my-suffix.model';

type EntityResponseType = HttpResponse<IAdresMySuffix>;
type EntityArrayResponseType = HttpResponse<IAdresMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class AdresMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/adres';

    constructor(private http: HttpClient) {}

    create(adres: IAdresMySuffix): Observable<EntityResponseType> {
        return this.http.post<IAdresMySuffix>(this.resourceUrl, adres, { observe: 'response' });
    }

    update(adres: IAdresMySuffix): Observable<EntityResponseType> {
        return this.http.put<IAdresMySuffix>(this.resourceUrl, adres, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IAdresMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IAdresMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
