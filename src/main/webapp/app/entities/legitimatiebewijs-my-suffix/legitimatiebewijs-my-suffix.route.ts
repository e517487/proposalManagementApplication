import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { LegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';
import { LegitimatiebewijsMySuffixService } from './legitimatiebewijs-my-suffix.service';
import { LegitimatiebewijsMySuffixComponent } from './legitimatiebewijs-my-suffix.component';
import { LegitimatiebewijsMySuffixDetailComponent } from './legitimatiebewijs-my-suffix-detail.component';
import { LegitimatiebewijsMySuffixUpdateComponent } from './legitimatiebewijs-my-suffix-update.component';
import { LegitimatiebewijsMySuffixDeletePopupComponent } from './legitimatiebewijs-my-suffix-delete-dialog.component';
import { ILegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class LegitimatiebewijsMySuffixResolve implements Resolve<ILegitimatiebewijsMySuffix> {
    constructor(private service: LegitimatiebewijsMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((legitimatiebewijs: HttpResponse<LegitimatiebewijsMySuffix>) => legitimatiebewijs.body);
        }
        return Observable.of(new LegitimatiebewijsMySuffix());
    }
}

export const legitimatiebewijsRoute: Routes = [
    {
        path: 'legitimatiebewijs-my-suffix',
        component: LegitimatiebewijsMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.legitimatiebewijs.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'legitimatiebewijs-my-suffix/:id/view',
        component: LegitimatiebewijsMySuffixDetailComponent,
        resolve: {
            legitimatiebewijs: LegitimatiebewijsMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.legitimatiebewijs.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'legitimatiebewijs-my-suffix/new',
        component: LegitimatiebewijsMySuffixUpdateComponent,
        resolve: {
            legitimatiebewijs: LegitimatiebewijsMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.legitimatiebewijs.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'legitimatiebewijs-my-suffix/:id/edit',
        component: LegitimatiebewijsMySuffixUpdateComponent,
        resolve: {
            legitimatiebewijs: LegitimatiebewijsMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.legitimatiebewijs.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const legitimatiebewijsPopupRoute: Routes = [
    {
        path: 'legitimatiebewijs-my-suffix/:id/delete',
        component: LegitimatiebewijsMySuffixDeletePopupComponent,
        resolve: {
            legitimatiebewijs: LegitimatiebewijsMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.legitimatiebewijs.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
