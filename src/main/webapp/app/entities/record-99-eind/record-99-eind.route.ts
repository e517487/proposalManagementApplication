import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record99Eind } from 'app/shared/model/record-99-eind.model';
import { Record99EindService } from './record-99-eind.service';
import { Record99EindComponent } from './record-99-eind.component';
import { Record99EindDetailComponent } from './record-99-eind-detail.component';
import { Record99EindUpdateComponent } from './record-99-eind-update.component';
import { Record99EindDeletePopupComponent } from './record-99-eind-delete-dialog.component';
import { IRecord99Eind } from 'app/shared/model/record-99-eind.model';

@Injectable({ providedIn: 'root' })
export class Record99EindResolve implements Resolve<IRecord99Eind> {
    constructor(private service: Record99EindService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record99Eind: HttpResponse<Record99Eind>) => record99Eind.body);
        }
        return Observable.of(new Record99Eind());
    }
}

export const record99EindRoute: Routes = [
    {
        path: 'record-99-eind',
        component: Record99EindComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-eind/:id/view',
        component: Record99EindDetailComponent,
        resolve: {
            record99Eind: Record99EindResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-eind/new',
        component: Record99EindUpdateComponent,
        resolve: {
            record99Eind: Record99EindResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-eind/:id/edit',
        component: Record99EindUpdateComponent,
        resolve: {
            record99Eind: Record99EindResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record99EindPopupRoute: Routes = [
    {
        path: 'record-99-eind/:id/delete',
        component: Record99EindDeletePopupComponent,
        resolve: {
            record99Eind: Record99EindResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
