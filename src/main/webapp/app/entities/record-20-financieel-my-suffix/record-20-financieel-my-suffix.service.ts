import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord20FinancieelMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord20FinancieelMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record20FinancieelMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-20-financieels';

    constructor(private http: HttpClient) {}

    create(record20Financieel: IRecord20FinancieelMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord20FinancieelMySuffix>(this.resourceUrl, record20Financieel, { observe: 'response' });
    }

    update(record20Financieel: IRecord20FinancieelMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord20FinancieelMySuffix>(this.resourceUrl, record20Financieel, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord20FinancieelMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord20FinancieelMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
