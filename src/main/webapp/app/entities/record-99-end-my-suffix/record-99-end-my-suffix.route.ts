import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';
import { Record99EndMySuffixService } from './record-99-end-my-suffix.service';
import { Record99EndMySuffixComponent } from './record-99-end-my-suffix.component';
import { Record99EndMySuffixDetailComponent } from './record-99-end-my-suffix-detail.component';
import { Record99EndMySuffixUpdateComponent } from './record-99-end-my-suffix-update.component';
import { Record99EndMySuffixDeletePopupComponent } from './record-99-end-my-suffix-delete-dialog.component';
import { IRecord99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record99EndMySuffixResolve implements Resolve<IRecord99EndMySuffix> {
    constructor(private service: Record99EndMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record99End: HttpResponse<Record99EndMySuffix>) => record99End.body);
        }
        return Observable.of(new Record99EndMySuffix());
    }
}

export const record99EndRoute: Routes = [
    {
        path: 'record-99-end-my-suffix',
        component: Record99EndMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99End.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-end-my-suffix/:id/view',
        component: Record99EndMySuffixDetailComponent,
        resolve: {
            record99End: Record99EndMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99End.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-end-my-suffix/new',
        component: Record99EndMySuffixUpdateComponent,
        resolve: {
            record99End: Record99EndMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99End.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-end-my-suffix/:id/edit',
        component: Record99EndMySuffixUpdateComponent,
        resolve: {
            record99End: Record99EndMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99End.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record99EndPopupRoute: Routes = [
    {
        path: 'record-99-end-my-suffix/:id/delete',
        component: Record99EndMySuffixDeletePopupComponent,
        resolve: {
            record99End: Record99EndMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99End.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
