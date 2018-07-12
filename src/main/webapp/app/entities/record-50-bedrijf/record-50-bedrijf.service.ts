import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';

type EntityResponseType = HttpResponse<IRecord50Bedrijf>;
type EntityArrayResponseType = HttpResponse<IRecord50Bedrijf[]>;

@Injectable({ providedIn: 'root' })
export class Record50BedrijfService {
    private resourceUrl = SERVER_API_URL + 'api/record-50-bedrijfs';

    constructor(private http: HttpClient) {}

    create(record50Bedrijf: IRecord50Bedrijf): Observable<EntityResponseType> {
        return this.http.post<IRecord50Bedrijf>(this.resourceUrl, record50Bedrijf, { observe: 'response' });
    }

    update(record50Bedrijf: IRecord50Bedrijf): Observable<EntityResponseType> {
        return this.http.put<IRecord50Bedrijf>(this.resourceUrl, record50Bedrijf, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord50Bedrijf>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord50Bedrijf[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
