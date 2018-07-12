import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord25HerfinancieeringMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord25HerfinancieeringMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record25HerfinancieeringMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-25-herfinancieerings';

    constructor(private http: HttpClient) {}

    create(record25Herfinancieering: IRecord25HerfinancieeringMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord25HerfinancieeringMySuffix>(this.resourceUrl, record25Herfinancieering, { observe: 'response' });
    }

    update(record25Herfinancieering: IRecord25HerfinancieeringMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord25HerfinancieeringMySuffix>(this.resourceUrl, record25Herfinancieering, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord25HerfinancieeringMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord25HerfinancieeringMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
