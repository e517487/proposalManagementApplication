import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';
import { Record46RelatieHuishoudelijkService } from './record-46-relatie-huishoudelijk.service';
import { Record46RelatieHuishoudelijkComponent } from './record-46-relatie-huishoudelijk.component';
import { Record46RelatieHuishoudelijkDetailComponent } from './record-46-relatie-huishoudelijk-detail.component';
import { Record46RelatieHuishoudelijkUpdateComponent } from './record-46-relatie-huishoudelijk-update.component';
import { Record46RelatieHuishoudelijkDeletePopupComponent } from './record-46-relatie-huishoudelijk-delete-dialog.component';
import { IRecord46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';

@Injectable({ providedIn: 'root' })
export class Record46RelatieHuishoudelijkResolve implements Resolve<IRecord46RelatieHuishoudelijk> {
    constructor(private service: Record46RelatieHuishoudelijkService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map((record46RelatieHuishoudelijk: HttpResponse<Record46RelatieHuishoudelijk>) => record46RelatieHuishoudelijk.body);
        }
        return Observable.of(new Record46RelatieHuishoudelijk());
    }
}

export const record46RelatieHuishoudelijkRoute: Routes = [
    {
        path: 'record-46-relatie-huishoudelijk',
        component: Record46RelatieHuishoudelijkComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-46-relatie-huishoudelijk/:id/view',
        component: Record46RelatieHuishoudelijkDetailComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-46-relatie-huishoudelijk/new',
        component: Record46RelatieHuishoudelijkUpdateComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-46-relatie-huishoudelijk/:id/edit',
        component: Record46RelatieHuishoudelijkUpdateComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record46RelatieHuishoudelijkPopupRoute: Routes = [
    {
        path: 'record-46-relatie-huishoudelijk/:id/delete',
        component: Record46RelatieHuishoudelijkDeletePopupComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
