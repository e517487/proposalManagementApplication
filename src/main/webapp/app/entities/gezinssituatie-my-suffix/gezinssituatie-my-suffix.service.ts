import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IGezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';

type EntityResponseType = HttpResponse<IGezinssituatieMySuffix>;
type EntityArrayResponseType = HttpResponse<IGezinssituatieMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class GezinssituatieMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/gezinssituaties';

    constructor(private http: HttpClient) {}

    create(gezinssituatie: IGezinssituatieMySuffix): Observable<EntityResponseType> {
        return this.http.post<IGezinssituatieMySuffix>(this.resourceUrl, gezinssituatie, { observe: 'response' });
    }

    update(gezinssituatie: IGezinssituatieMySuffix): Observable<EntityResponseType> {
        return this.http.put<IGezinssituatieMySuffix>(this.resourceUrl, gezinssituatie, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IGezinssituatieMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IGezinssituatieMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
