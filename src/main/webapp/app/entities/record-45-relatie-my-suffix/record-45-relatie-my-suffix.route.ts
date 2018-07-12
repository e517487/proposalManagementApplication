import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';
import { Record45RelatieMySuffixService } from './record-45-relatie-my-suffix.service';
import { Record45RelatieMySuffixComponent } from './record-45-relatie-my-suffix.component';
import { Record45RelatieMySuffixDetailComponent } from './record-45-relatie-my-suffix-detail.component';
import { Record45RelatieMySuffixUpdateComponent } from './record-45-relatie-my-suffix-update.component';
import { Record45RelatieMySuffixDeletePopupComponent } from './record-45-relatie-my-suffix-delete-dialog.component';
import { IRecord45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record45RelatieMySuffixResolve implements Resolve<IRecord45RelatieMySuffix> {
    constructor(private service: Record45RelatieMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record45Relatie: HttpResponse<Record45RelatieMySuffix>) => record45Relatie.body);
        }
        return Observable.of(new Record45RelatieMySuffix());
    }
}

export const record45RelatieRoute: Routes = [
    {
        path: 'record-45-relatie-my-suffix',
        component: Record45RelatieMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-45-relatie-my-suffix/:id/view',
        component: Record45RelatieMySuffixDetailComponent,
        resolve: {
            record45Relatie: Record45RelatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-45-relatie-my-suffix/new',
        component: Record45RelatieMySuffixUpdateComponent,
        resolve: {
            record45Relatie: Record45RelatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-45-relatie-my-suffix/:id/edit',
        component: Record45RelatieMySuffixUpdateComponent,
        resolve: {
            record45Relatie: Record45RelatieMySuffixResolve
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
        path: 'record-45-relatie-my-suffix/:id/delete',
        component: Record45RelatieMySuffixDeletePopupComponent,
        resolve: {
            record45Relatie: Record45RelatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record45Relatie.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
