import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';
import { Record99EindMySuffixService } from './record-99-eind-my-suffix.service';
import { Record99EindMySuffixComponent } from './record-99-eind-my-suffix.component';
import { Record99EindMySuffixDetailComponent } from './record-99-eind-my-suffix-detail.component';
import { Record99EindMySuffixUpdateComponent } from './record-99-eind-my-suffix-update.component';
import { Record99EindMySuffixDeletePopupComponent } from './record-99-eind-my-suffix-delete-dialog.component';
import { IRecord99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record99EindMySuffixResolve implements Resolve<IRecord99EindMySuffix> {
    constructor(private service: Record99EindMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record99Eind: HttpResponse<Record99EindMySuffix>) => record99Eind.body);
        }
        return Observable.of(new Record99EindMySuffix());
    }
}

export const record99EindRoute: Routes = [
    {
        path: 'record-99-eind-my-suffix',
        component: Record99EindMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-eind-my-suffix/:id/view',
        component: Record99EindMySuffixDetailComponent,
        resolve: {
            record99Eind: Record99EindMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-eind-my-suffix/new',
        component: Record99EindMySuffixUpdateComponent,
        resolve: {
            record99Eind: Record99EindMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-99-eind-my-suffix/:id/edit',
        component: Record99EindMySuffixUpdateComponent,
        resolve: {
            record99Eind: Record99EindMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record99EindPopupRoute: Routes = [
    {
        path: 'record-99-eind-my-suffix/:id/delete',
        component: Record99EindMySuffixDeletePopupComponent,
        resolve: {
            record99Eind: Record99EindMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record99Eind.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
