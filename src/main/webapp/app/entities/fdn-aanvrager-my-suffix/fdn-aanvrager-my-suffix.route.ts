import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { FdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';
import { FdnAanvragerMySuffixService } from './fdn-aanvrager-my-suffix.service';
import { FdnAanvragerMySuffixComponent } from './fdn-aanvrager-my-suffix.component';
import { FdnAanvragerMySuffixDetailComponent } from './fdn-aanvrager-my-suffix-detail.component';
import { FdnAanvragerMySuffixUpdateComponent } from './fdn-aanvrager-my-suffix-update.component';
import { FdnAanvragerMySuffixDeletePopupComponent } from './fdn-aanvrager-my-suffix-delete-dialog.component';
import { IFdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class FdnAanvragerMySuffixResolve implements Resolve<IFdnAanvragerMySuffix> {
    constructor(private service: FdnAanvragerMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((fdnAanvrager: HttpResponse<FdnAanvragerMySuffix>) => fdnAanvrager.body);
        }
        return Observable.of(new FdnAanvragerMySuffix());
    }
}

export const fdnAanvragerRoute: Routes = [
    {
        path: 'fdn-aanvrager-my-suffix',
        component: FdnAanvragerMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.fdnAanvrager.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'fdn-aanvrager-my-suffix/:id/view',
        component: FdnAanvragerMySuffixDetailComponent,
        resolve: {
            fdnAanvrager: FdnAanvragerMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.fdnAanvrager.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'fdn-aanvrager-my-suffix/new',
        component: FdnAanvragerMySuffixUpdateComponent,
        resolve: {
            fdnAanvrager: FdnAanvragerMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.fdnAanvrager.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'fdn-aanvrager-my-suffix/:id/edit',
        component: FdnAanvragerMySuffixUpdateComponent,
        resolve: {
            fdnAanvrager: FdnAanvragerMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.fdnAanvrager.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const fdnAanvragerPopupRoute: Routes = [
    {
        path: 'fdn-aanvrager-my-suffix/:id/delete',
        component: FdnAanvragerMySuffixDeletePopupComponent,
        resolve: {
            fdnAanvrager: FdnAanvragerMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.fdnAanvrager.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
