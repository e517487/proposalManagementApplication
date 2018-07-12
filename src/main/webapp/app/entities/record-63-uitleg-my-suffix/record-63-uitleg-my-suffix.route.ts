import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';
import { Record63UitlegMySuffixService } from './record-63-uitleg-my-suffix.service';
import { Record63UitlegMySuffixComponent } from './record-63-uitleg-my-suffix.component';
import { Record63UitlegMySuffixDetailComponent } from './record-63-uitleg-my-suffix-detail.component';
import { Record63UitlegMySuffixUpdateComponent } from './record-63-uitleg-my-suffix-update.component';
import { Record63UitlegMySuffixDeletePopupComponent } from './record-63-uitleg-my-suffix-delete-dialog.component';
import { IRecord63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record63UitlegMySuffixResolve implements Resolve<IRecord63UitlegMySuffix> {
    constructor(private service: Record63UitlegMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record63Uitleg: HttpResponse<Record63UitlegMySuffix>) => record63Uitleg.body);
        }
        return Observable.of(new Record63UitlegMySuffix());
    }
}

export const record63UitlegRoute: Routes = [
    {
        path: 'record-63-uitleg-my-suffix',
        component: Record63UitlegMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-63-uitleg-my-suffix/:id/view',
        component: Record63UitlegMySuffixDetailComponent,
        resolve: {
            record63Uitleg: Record63UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-63-uitleg-my-suffix/new',
        component: Record63UitlegMySuffixUpdateComponent,
        resolve: {
            record63Uitleg: Record63UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-63-uitleg-my-suffix/:id/edit',
        component: Record63UitlegMySuffixUpdateComponent,
        resolve: {
            record63Uitleg: Record63UitlegMySuffixResolve
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
        path: 'record-63-uitleg-my-suffix/:id/delete',
        component: Record63UitlegMySuffixDeletePopupComponent,
        resolve: {
            record63Uitleg: Record63UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record63Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
