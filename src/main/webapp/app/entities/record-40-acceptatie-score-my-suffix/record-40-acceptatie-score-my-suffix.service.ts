import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord40AcceptatieScoreMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord40AcceptatieScoreMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record40AcceptatieScoreMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-40-acceptatie-scores';

    constructor(private http: HttpClient) {}

    create(record40AcceptatieScore: IRecord40AcceptatieScoreMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord40AcceptatieScoreMySuffix>(this.resourceUrl, record40AcceptatieScore, { observe: 'response' });
    }

    update(record40AcceptatieScore: IRecord40AcceptatieScoreMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord40AcceptatieScoreMySuffix>(this.resourceUrl, record40AcceptatieScore, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord40AcceptatieScoreMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord40AcceptatieScoreMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
