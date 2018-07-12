import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';
import { Record61UitlegMySuffixService } from './record-61-uitleg-my-suffix.service';
import { Record61UitlegMySuffixComponent } from './record-61-uitleg-my-suffix.component';
import { Record61UitlegMySuffixDetailComponent } from './record-61-uitleg-my-suffix-detail.component';
import { Record61UitlegMySuffixUpdateComponent } from './record-61-uitleg-my-suffix-update.component';
import { Record61UitlegMySuffixDeletePopupComponent } from './record-61-uitleg-my-suffix-delete-dialog.component';
import { IRecord61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record61UitlegMySuffixResolve implements Resolve<IRecord61UitlegMySuffix> {
    constructor(private service: Record61UitlegMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record61Uitleg: HttpResponse<Record61UitlegMySuffix>) => record61Uitleg.body);
        }
        return Observable.of(new Record61UitlegMySuffix());
    }
}

export const record61UitlegRoute: Routes = [
    {
        path: 'record-61-uitleg-my-suffix',
        component: Record61UitlegMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-61-uitleg-my-suffix/:id/view',
        component: Record61UitlegMySuffixDetailComponent,
        resolve: {
            record61Uitleg: Record61UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-61-uitleg-my-suffix/new',
        component: Record61UitlegMySuffixUpdateComponent,
        resolve: {
            record61Uitleg: Record61UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-61-uitleg-my-suffix/:id/edit',
        component: Record61UitlegMySuffixUpdateComponent,
        resolve: {
            record61Uitleg: Record61UitlegMySuffixResolve
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
        path: 'record-61-uitleg-my-suffix/:id/delete',
        component: Record61UitlegMySuffixDeletePopupComponent,
        resolve: {
            record61Uitleg: Record61UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record61Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
