import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { INawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';

type EntityResponseType = HttpResponse<INawWerkgeverUWVMySuffix>;
type EntityArrayResponseType = HttpResponse<INawWerkgeverUWVMySuffix[]>;

@Injectable({ providedIn: 'root' })
export class NawWerkgeverUWVMySuffixService {
    private resourceUrl = SERVER_API_URL + 'api/naw-werkgever-uwvs';

    constructor(private http: HttpClient) {}

    create(nawWerkgeverUWV: INawWerkgeverUWVMySuffix): Observable<EntityResponseType> {
        return this.http.post<INawWerkgeverUWVMySuffix>(this.resourceUrl, nawWerkgeverUWV, { observe: 'response' });
    }

    update(nawWerkgeverUWV: INawWerkgeverUWVMySuffix): Observable<EntityResponseType> {
        return this.http.put<INawWerkgeverUWVMySuffix>(this.resourceUrl, nawWerkgeverUWV, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<INawWerkgeverUWVMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<INawWerkgeverUWVMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
