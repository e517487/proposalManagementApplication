import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';

type EntityResponseType = HttpResponse<IRekenmoduleAanvraagMySuffix>;
type EntityArrayResponseType = HttpResponse<IRekenmoduleAanvraagMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class RekenmoduleAanvraagMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/rekenmodule-aanvraags';

    constructor(private http: HttpClient) {}

    create(rekenmoduleAanvraag: IRekenmoduleAanvraagMySuffix): Observable<EntityResponseType> {
        return this.http.post<IRekenmoduleAanvraagMySuffix>(this.resourceUrl, rekenmoduleAanvraag, { observe: 'response' });
    }

    update(rekenmoduleAanvraag: IRekenmoduleAanvraagMySuffix): Observable<EntityResponseType> {
        return this.http.put<IRekenmoduleAanvraagMySuffix>(this.resourceUrl, rekenmoduleAanvraag, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRekenmoduleAanvraagMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRekenmoduleAanvraagMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
