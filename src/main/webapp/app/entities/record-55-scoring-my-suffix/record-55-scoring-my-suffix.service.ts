import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord55ScoringMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord55ScoringMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record55ScoringMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-55-scorings';

    constructor(private http: HttpClient) {}

    create(record55Scoring: IRecord55ScoringMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord55ScoringMySuffix>(this.resourceUrl, record55Scoring, { observe: 'response' });
    }

    update(record55Scoring: IRecord55ScoringMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord55ScoringMySuffix>(this.resourceUrl, record55Scoring, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord55ScoringMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord55ScoringMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
