import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord20Financieel } from 'app/shared/model/record-20-financieel.model';

type EntityResponseType = HttpResponse<IRecord20Financieel>;
type EntityArrayResponseType = HttpResponse<IRecord20Financieel[]>;

@Injectable({ providedIn: 'root' })
export class Record20FinancieelService {
    private resourceUrl = SERVER_API_URL + 'api/record-20-financieels';

    constructor(private http: HttpClient) {}

    create(record20Financieel: IRecord20Financieel): Observable<EntityResponseType> {
        return this.http.post<IRecord20Financieel>(this.resourceUrl, record20Financieel, { observe: 'response' });
    }

    update(record20Financieel: IRecord20Financieel): Observable<EntityResponseType> {
        return this.http.put<IRecord20Financieel>(this.resourceUrl, record20Financieel, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord20Financieel>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord20Financieel[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
