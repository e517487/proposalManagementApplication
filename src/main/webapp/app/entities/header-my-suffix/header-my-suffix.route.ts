import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { HeaderMySuffix } from 'app/shared/model/header-my-suffix.model';
import { HeaderMySuffixService } from './header-my-suffix.service';
import { HeaderMySuffixComponent } from './header-my-suffix.component';
import { HeaderMySuffixDetailComponent } from './header-my-suffix-detail.component';
import { HeaderMySuffixUpdateComponent } from './header-my-suffix-update.component';
import { HeaderMySuffixDeletePopupComponent } from './header-my-suffix-delete-dialog.component';
import { IHeaderMySuffix } from 'app/shared/model/header-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class HeaderMySuffixResolve implements Resolve<IHeaderMySuffix> {
    constructor(private service: HeaderMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((header: HttpResponse<HeaderMySuffix>) => header.body);
        }
        return Observable.of(new HeaderMySuffix());
    }
}

export const headerRoute: Routes = [
    {
        path: 'header-my-suffix',
        component: HeaderMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.header.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'header-my-suffix/:id/view',
        component: HeaderMySuffixDetailComponent,
        resolve: {
            header: HeaderMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.header.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'header-my-suffix/new',
        component: HeaderMySuffixUpdateComponent,
        resolve: {
            header: HeaderMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.header.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'header-my-suffix/:id/edit',
        component: HeaderMySuffixUpdateComponent,
        resolve: {
            header: HeaderMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.header.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const headerPopupRoute: Routes = [
    {
        path: 'header-my-suffix/:id/delete',
        component: HeaderMySuffixDeletePopupComponent,
        resolve: {
            header: HeaderMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.header.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
