import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';

type EntityResponseType = HttpResponse<IRecord46RelatieHuishoudelijk>;
type EntityArrayResponseType = HttpResponse<IRecord46RelatieHuishoudelijk[]>;

@Injectable({ providedIn: 'root' })
export class Record46RelatieHuishoudelijkService {
    private resourceUrl = SERVER_API_URL + 'api/record-46-relatie-huishoudelijks';

    constructor(private http: HttpClient) {}

    create(record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijk): Observable<EntityResponseType> {
        return this.http.post<IRecord46RelatieHuishoudelijk>(this.resourceUrl, record46RelatieHuishoudelijk, { observe: 'response' });
    }

    update(record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijk): Observable<EntityResponseType> {
        return this.http.put<IRecord46RelatieHuishoudelijk>(this.resourceUrl, record46RelatieHuishoudelijk, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord46RelatieHuishoudelijk>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord46RelatieHuishoudelijk[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
