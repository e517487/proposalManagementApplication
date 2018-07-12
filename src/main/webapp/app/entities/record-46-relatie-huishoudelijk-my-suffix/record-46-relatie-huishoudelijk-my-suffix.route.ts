import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';
import { Record46RelatieHuishoudelijkMySuffixService } from './record-46-relatie-huishoudelijk-my-suffix.service';
import { Record46RelatieHuishoudelijkMySuffixComponent } from './record-46-relatie-huishoudelijk-my-suffix.component';
import { Record46RelatieHuishoudelijkMySuffixDetailComponent } from './record-46-relatie-huishoudelijk-my-suffix-detail.component';
import { Record46RelatieHuishoudelijkMySuffixUpdateComponent } from './record-46-relatie-huishoudelijk-my-suffix-update.component';
import { Record46RelatieHuishoudelijkMySuffixDeletePopupComponent } from './record-46-relatie-huishoudelijk-my-suffix-delete-dialog.component';
import { IRecord46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record46RelatieHuishoudelijkMySuffixResolve implements Resolve<IRecord46RelatieHuishoudelijkMySuffix> {
    constructor(private service: Record46RelatieHuishoudelijkMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map(
                    (record46RelatieHuishoudelijk: HttpResponse<Record46RelatieHuishoudelijkMySuffix>) => record46RelatieHuishoudelijk.body
                );
        }
        return Observable.of(new Record46RelatieHuishoudelijkMySuffix());
    }
}

export const record46RelatieHuishoudelijkRoute: Routes = [
    {
        path: 'record-46-relatie-huishoudelijk-my-suffix',
        component: Record46RelatieHuishoudelijkMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-46-relatie-huishoudelijk-my-suffix/:id/view',
        component: Record46RelatieHuishoudelijkMySuffixDetailComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-46-relatie-huishoudelijk-my-suffix/new',
        component: Record46RelatieHuishoudelijkMySuffixUpdateComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-46-relatie-huishoudelijk-my-suffix/:id/edit',
        component: Record46RelatieHuishoudelijkMySuffixUpdateComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkMySuffixResolve
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
        path: 'record-46-relatie-huishoudelijk-my-suffix/:id/delete',
        component: Record46RelatieHuishoudelijkMySuffixDeletePopupComponent,
        resolve: {
            record46RelatieHuishoudelijk: Record46RelatieHuishoudelijkMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record46RelatieHuishoudelijk.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
