import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IFinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';

type EntityResponseType = HttpResponse<IFinancieleSituatieMySuffix>;
type EntityArrayResponseType = HttpResponse<IFinancieleSituatieMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class FinancieleSituatieMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/financiele-situaties';

    constructor(private http: HttpClient) {}

    create(financieleSituatie: IFinancieleSituatieMySuffix): Observable<EntityResponseType> {
        return this.http.post<IFinancieleSituatieMySuffix>(this.resourceUrl, financieleSituatie, { observe: 'response' });
    }

    update(financieleSituatie: IFinancieleSituatieMySuffix): Observable<EntityResponseType> {
        return this.http.put<IFinancieleSituatieMySuffix>(this.resourceUrl, financieleSituatie, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IFinancieleSituatieMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IFinancieleSituatieMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
