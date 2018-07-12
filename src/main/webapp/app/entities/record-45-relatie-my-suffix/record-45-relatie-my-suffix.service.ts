import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord45RelatieMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord45RelatieMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record45RelatieMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-45-relaties';

    constructor(private http: HttpClient) {}

    create(record45Relatie: IRecord45RelatieMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord45RelatieMySuffix>(this.resourceUrl, record45Relatie, { observe: 'response' });
    }

    update(record45Relatie: IRecord45RelatieMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord45RelatieMySuffix>(this.resourceUrl, record45Relatie, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord45RelatieMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord45RelatieMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
