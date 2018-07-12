import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';
import { Record35ObjectMySuffixService } from './record-35-object-my-suffix.service';
import { Record35ObjectMySuffixComponent } from './record-35-object-my-suffix.component';
import { Record35ObjectMySuffixDetailComponent } from './record-35-object-my-suffix-detail.component';
import { Record35ObjectMySuffixUpdateComponent } from './record-35-object-my-suffix-update.component';
import { Record35ObjectMySuffixDeletePopupComponent } from './record-35-object-my-suffix-delete-dialog.component';
import { IRecord35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record35ObjectMySuffixResolve implements Resolve<IRecord35ObjectMySuffix> {
    constructor(private service: Record35ObjectMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record35Object: HttpResponse<Record35ObjectMySuffix>) => record35Object.body);
        }
        return Observable.of(new Record35ObjectMySuffix());
    }
}

export const record35ObjectRoute: Routes = [
    {
        path: 'record-35-object-my-suffix',
        component: Record35ObjectMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-35-object-my-suffix/:id/view',
        component: Record35ObjectMySuffixDetailComponent,
        resolve: {
            record35Object: Record35ObjectMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-35-object-my-suffix/new',
        component: Record35ObjectMySuffixUpdateComponent,
        resolve: {
            record35Object: Record35ObjectMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-35-object-my-suffix/:id/edit',
        component: Record35ObjectMySuffixUpdateComponent,
        resolve: {
            record35Object: Record35ObjectMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record35ObjectPopupRoute: Routes = [
    {
        path: 'record-35-object-my-suffix/:id/delete',
        component: Record35ObjectMySuffixDeletePopupComponent,
        resolve: {
            record35Object: Record35ObjectMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
