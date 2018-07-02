import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { AlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';
import { AlgemeenMySuffixService } from './algemeen-my-suffix.service';
import { AlgemeenMySuffixComponent } from './algemeen-my-suffix.component';
import { AlgemeenMySuffixDetailComponent } from './algemeen-my-suffix-detail.component';
import { AlgemeenMySuffixUpdateComponent } from './algemeen-my-suffix-update.component';
import { AlgemeenMySuffixDeletePopupComponent } from './algemeen-my-suffix-delete-dialog.component';
import { IAlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class AlgemeenMySuffixResolve implements Resolve<IAlgemeenMySuffix> {
    constructor(private service: AlgemeenMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((algemeen: HttpResponse<AlgemeenMySuffix>) => algemeen.body);
        }
        return Observable.of(new AlgemeenMySuffix());
    }
}

export const algemeenRoute: Routes = [
    {
        path: 'algemeen-my-suffix',
        component: AlgemeenMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.algemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'algemeen-my-suffix/:id/view',
        component: AlgemeenMySuffixDetailComponent,
        resolve: {
            algemeen: AlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.algemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'algemeen-my-suffix/new',
        component: AlgemeenMySuffixUpdateComponent,
        resolve: {
            algemeen: AlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.algemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'algemeen-my-suffix/:id/edit',
        component: AlgemeenMySuffixUpdateComponent,
        resolve: {
            algemeen: AlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.algemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const algemeenPopupRoute: Routes = [
    {
        path: 'algemeen-my-suffix/:id/delete',
        component: AlgemeenMySuffixDeletePopupComponent,
        resolve: {
            algemeen: AlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.algemeen.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
