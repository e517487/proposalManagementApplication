import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { RequestMySuffix } from 'app/shared/model/request-my-suffix.model';
import { RequestMySuffixService } from './request-my-suffix.service';
import { RequestMySuffixComponent } from './request-my-suffix.component';
import { RequestMySuffixDetailComponent } from './request-my-suffix-detail.component';
import { RequestMySuffixUpdateComponent } from './request-my-suffix-update.component';
import { RequestMySuffixDeletePopupComponent } from './request-my-suffix-delete-dialog.component';
import { IRequestMySuffix } from 'app/shared/model/request-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class RequestMySuffixResolve implements Resolve<IRequestMySuffix> {
    constructor(private service: RequestMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((request: HttpResponse<RequestMySuffix>) => request.body);
        }
        return Observable.of(new RequestMySuffix());
    }
}

export const requestRoute: Routes = [
    {
        path: 'request-my-suffix',
        component: RequestMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.request.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'request-my-suffix/:id/view',
        component: RequestMySuffixDetailComponent,
        resolve: {
            request: RequestMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.request.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'request-my-suffix/new',
        component: RequestMySuffixUpdateComponent,
        resolve: {
            request: RequestMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.request.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'request-my-suffix/:id/edit',
        component: RequestMySuffixUpdateComponent,
        resolve: {
            request: RequestMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.request.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const requestPopupRoute: Routes = [
    {
        path: 'request-my-suffix/:id/delete',
        component: RequestMySuffixDeletePopupComponent,
        resolve: {
            request: RequestMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.request.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
