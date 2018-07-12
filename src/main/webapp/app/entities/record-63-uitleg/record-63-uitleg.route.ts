import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record63Uitleg } from 'app/shared/model/record-63-uitleg.model';
import { Record63UitlegService } from './record-63-uitleg.service';
import { Record63UitlegComponent } from './record-63-uitleg.component';
import { Record63UitlegDetailComponent } from './record-63-uitleg-detail.component';
import { Record63UitlegUpdateComponent } from './record-63-uitleg-update.component';
import { Record63UitlegDeletePopupComponent } from './record-63-uitleg-delete-dialog.component';
import { IRecord63Uitleg } from 'app/shared/model/record-63-uitleg.model';

@Injectable({ providedIn: 'root' })
export class Record63UitlegResolve implements Resolve<IRecord63Uitleg> {
    constructor(private service: Record63UitlegService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record63Uitleg: HttpResponse<Record63Uitleg>) => record63Uitleg.body);
        }
        return Observable.of(new Record63Uitleg());
    }
}

export const record63UitlegRoute: Routes = [
    {
        path: 'record-63-uitleg',
        component: Record63UitlegComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-63-uitleg/:id/view',
        component: Record63UitlegDetailComponent,
        resolve: {
            record63Uitleg: Record63UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-63-uitleg/new',
        component: Record63UitlegUpdateComponent,
        resolve: {
            record63Uitleg: Record63UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-63-uitleg/:id/edit',
        component: Record63UitlegUpdateComponent,
        resolve: {
            record63Uitleg: Record63UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record63UitlegPopupRoute: Routes = [
    {
        path: 'record-63-uitleg/:id/delete',
        component: Record63UitlegDeletePopupComponent,
        resolve: {
            record63Uitleg: Record63UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
