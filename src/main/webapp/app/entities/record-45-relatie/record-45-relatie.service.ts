import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord45Relatie } from 'app/shared/model/record-45-relatie.model';

type EntityResponseType = HttpResponse<IRecord45Relatie>;
type EntityArrayResponseType = HttpResponse<IRecord45Relatie[]>;

@Injectable({ providedIn: 'root' })
export class Record45RelatieService {
    private resourceUrl = SERVER_API_URL + 'api/record-45-relaties';

    constructor(private http: HttpClient) {}

    create(record45Relatie: IRecord45Relatie): Observable<EntityResponseType> {
        return this.http.post<IRecord45Relatie>(this.resourceUrl, record45Relatie, { observe: 'response' });
    }

    update(record45Relatie: IRecord45Relatie): Observable<EntityResponseType> {
        return this.http.put<IRecord45Relatie>(this.resourceUrl, record45Relatie, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord45Relatie>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord45Relatie[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
