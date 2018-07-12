import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';

type EntityResponseType = HttpResponse<IRecord25Herfinancieering>;
type EntityArrayResponseType = HttpResponse<IRecord25Herfinancieering[]>;

@Injectable({ providedIn: 'root' })
export class Record25HerfinancieeringService {
    private resourceUrl = SERVER_API_URL + 'api/record-25-herfinancieerings';

    constructor(private http: HttpClient) {}

    create(record25Herfinancieering: IRecord25Herfinancieering): Observable<EntityResponseType> {
        return this.http.post<IRecord25Herfinancieering>(this.resourceUrl, record25Herfinancieering, { observe: 'response' });
    }

    update(record25Herfinancieering: IRecord25Herfinancieering): Observable<EntityResponseType> {
        return this.http.put<IRecord25Herfinancieering>(this.resourceUrl, record25Herfinancieering, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord25Herfinancieering>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord25Herfinancieering[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
