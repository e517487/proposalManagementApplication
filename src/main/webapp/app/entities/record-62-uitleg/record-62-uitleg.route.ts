import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record62Uitleg } from 'app/shared/model/record-62-uitleg.model';
import { Record62UitlegService } from './record-62-uitleg.service';
import { Record62UitlegComponent } from './record-62-uitleg.component';
import { Record62UitlegDetailComponent } from './record-62-uitleg-detail.component';
import { Record62UitlegUpdateComponent } from './record-62-uitleg-update.component';
import { Record62UitlegDeletePopupComponent } from './record-62-uitleg-delete-dialog.component';
import { IRecord62Uitleg } from 'app/shared/model/record-62-uitleg.model';

@Injectable({ providedIn: 'root' })
export class Record62UitlegResolve implements Resolve<IRecord62Uitleg> {
    constructor(private service: Record62UitlegService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record62Uitleg: HttpResponse<Record62Uitleg>) => record62Uitleg.body);
        }
        return Observable.of(new Record62Uitleg());
    }
}

export const record62UitlegRoute: Routes = [
    {
        path: 'record-62-uitleg',
        component: Record62UitlegComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-62-uitleg/:id/view',
        component: Record62UitlegDetailComponent,
        resolve: {
            record62Uitleg: Record62UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-62-uitleg/new',
        component: Record62UitlegUpdateComponent,
        resolve: {
            record62Uitleg: Record62UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-62-uitleg/:id/edit',
        component: Record62UitlegUpdateComponent,
        resolve: {
            record62Uitleg: Record62UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record62UitlegPopupRoute: Routes = [
    {
        path: 'record-62-uitleg/:id/delete',
        component: Record62UitlegDeletePopupComponent,
        resolve: {
            record62Uitleg: Record62UitlegResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
