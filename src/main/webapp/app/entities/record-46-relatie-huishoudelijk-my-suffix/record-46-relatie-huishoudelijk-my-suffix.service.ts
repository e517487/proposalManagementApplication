import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRecord46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';

type EntityResponseType = HttpResponse<IRecord46RelatieHuishoudelijkMySuffix>;
type EntityArrayResponseType = HttpResponse<IRecord46RelatieHuishoudelijkMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class Record46RelatieHuishoudelijkMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/record-46-relatie-huishoudelijks';

    constructor(private http: HttpClient) {}

    create(record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijkMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRecord46RelatieHuishoudelijkMySuffix>(this.resourceUrl, record46RelatieHuishoudelijk, {
            observe: 'response'
        });
    }

    update(record46RelatieHuishoudelijk: IRecord46RelatieHuishoudelijkMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRecord46RelatieHuishoudelijkMySuffix>(this.resourceUrl, record46RelatieHuishoudelijk, {
            observe: 'response'
        });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRecord46RelatieHuishoudelijkMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRecord46RelatieHuishoudelijkMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
