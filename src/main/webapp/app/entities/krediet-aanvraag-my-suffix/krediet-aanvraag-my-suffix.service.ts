import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IKredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';

type EntityResponseType = HttpResponse<IKredietAanvraagMySuffix>;
type EntityArrayResponseType = HttpResponse<IKredietAanvraagMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class KredietAanvraagMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/krediet-aanvraags';

    constructor(private http: HttpClient) {}

    create(kredietAanvraag: IKredietAanvraagMySuffix): Observable<EntityResponseType> {
        return this.http.post<IKredietAanvraagMySuffix>(this.resourceUrl, kredietAanvraag, { observe: 'response' });
    }

    update(kredietAanvraag: IKredietAanvraagMySuffix): Observable<EntityResponseType> {
        return this.http.put<IKredietAanvraagMySuffix>(this.resourceUrl, kredietAanvraag, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IKredietAanvraagMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IKredietAanvraagMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
