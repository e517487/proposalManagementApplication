import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record45Relatie } from 'app/shared/model/record-45-relatie.model';
import { Record45RelatieService } from './record-45-relatie.service';
import { Record45RelatieComponent } from './record-45-relatie.component';
import { Record45RelatieDetailComponent } from './record-45-relatie-detail.component';
import { Record45RelatieUpdateComponent } from './record-45-relatie-update.component';
import { Record45RelatieDeletePopupComponent } from './record-45-relatie-delete-dialog.component';
import { IRecord45Relatie } from 'app/shared/model/record-45-relatie.model';

@Injectable({ providedIn: 'root' })
export class Record45RelatieResolve implements Resolve<IRecord45Relatie> {
    constructor(private service: Record45RelatieService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record45Relatie: HttpResponse<Record45Relatie>) => record45Relatie.body);
        }
        return Observable.of(new Record45Relatie());
    }
}

export const record45RelatieRoute: Routes = [
    {
        path: 'record-45-relatie',
        component: Record45RelatieComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-45-relatie/:id/view',
        component: Record45RelatieDetailComponent,
        resolve: {
            record45Relatie: Record45RelatieResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-45-relatie/new',
        component: Record45RelatieUpdateComponent,
        resolve: {
            record45Relatie: Record45RelatieResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-45-relatie/:id/edit',
        component: Record45RelatieUpdateComponent,
        resolve: {
            record45Relatie: Record45RelatieResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record45RelatiePopupRoute: Routes = [
    {
        path: 'record-45-relatie/:id/delete',
        component: Record45RelatieDeletePopupComponent,
        resolve: {
            record45Relatie: Record45RelatieResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
