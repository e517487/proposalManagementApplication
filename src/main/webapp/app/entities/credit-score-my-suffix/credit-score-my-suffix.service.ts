import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';

type EntityResponseType = HttpResponse<ICreditScoreMySuffix>;
type EntityArrayResponseType = HttpResponse<ICreditScoreMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class CreditScoreMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/credit-scores';

    constructor(private http: HttpClient) {}

    create(creditScore: ICreditScoreMySuffix): Observable<EntityResponseType> {
        return this.http.post<ICreditScoreMySuffix>(this.resourceUrl, creditScore, { observe: 'response' });
    }

    update(creditScore: ICreditScoreMySuffix): Observable<EntityResponseType> {
        return this.http.put<ICreditScoreMySuffix>(this.resourceUrl, creditScore, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ICreditScoreMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ICreditScoreMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
