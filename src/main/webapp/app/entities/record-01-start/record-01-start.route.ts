import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record01Start } from 'app/shared/model/record-01-start.model';
import { Record01StartService } from './record-01-start.service';
import { Record01StartComponent } from './record-01-start.component';
import { Record01StartDetailComponent } from './record-01-start-detail.component';
import { Record01StartUpdateComponent } from './record-01-start-update.component';
import { Record01StartDeletePopupComponent } from './record-01-start-delete-dialog.component';
import { IRecord01Start } from 'app/shared/model/record-01-start.model';

@Injectable({ providedIn: 'root' })
export class Record01StartResolve implements Resolve<IRecord01Start> {
    constructor(private service: Record01StartService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record01Start: HttpResponse<Record01Start>) => record01Start.body);
        }
        return Observable.of(new Record01Start());
    }
}

export const record01StartRoute: Routes = [
    {
        path: 'record-01-start',
        component: Record01StartComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-01-start/:id/view',
        component: Record01StartDetailComponent,
        resolve: {
            record01Start: Record01StartResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-01-start/new',
        component: Record01StartUpdateComponent,
        resolve: {
            record01Start: Record01StartResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-01-start/:id/edit',
        component: Record01StartUpdateComponent,
        resolve: {
            record01Start: Record01StartResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record01StartPopupRoute: Routes = [
    {
        path: 'record-01-start/:id/delete',
        component: Record01StartDeletePopupComponent,
        resolve: {
            record01Start: Record01StartResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
