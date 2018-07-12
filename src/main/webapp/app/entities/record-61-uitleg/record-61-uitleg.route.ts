import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record61Uitleg } from 'app/shared/model/record-61-uitleg.model';
import { Record61UitlegService } from './record-61-uitleg.service';
import { Record61UitlegComponent } from './record-61-uitleg.component';
import { Record61UitlegDetailComponent } from './record-61-uitleg-detail.component';
import { Record61UitlegUpdateComponent } from './record-61-uitleg-update.component';
import { Record61UitlegDeletePopupComponent } from './record-61-uitleg-delete-dialog.component';
import { IRecord61Uitleg } from 'app/shared/model/record-61-uitleg.model';

@Injectable({ providedIn: 'root' })
export class Record61UitlegResolve implements Resolve<IRecord61Uitleg> {
    constructor(private service: Record61UitlegService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record61Uitleg: HttpResponse<Record61Uitleg>) => record61Uitleg.body);
        }
        return Observable.of(new Record61Uitleg());
    }
}

export const record61UitlegRoute: Routes = [
    {
        path: 'record-61-uitleg',
        component: Record61UitlegComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-61-uitleg/:id/view',
        component: Record61UitlegDetailComponent,
        resolve: {
            record61Uitleg: Record61UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-61-uitleg/new',
        component: Record61UitlegUpdateComponent,
        resolve: {
            record61Uitleg: Record61UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-61-uitleg/:id/edit',
        component: Record61UitlegUpdateComponent,
        resolve: {
            record61Uitleg: Record61UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record61UitlegPopupRoute: Routes = [
    {
        path: 'record-61-uitleg/:id/delete',
        component: Record61UitlegDeletePopupComponent,
        resolve: {
            record61Uitleg: Record61UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
