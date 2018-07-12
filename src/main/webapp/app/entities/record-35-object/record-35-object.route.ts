import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record35Object } from 'app/shared/model/record-35-object.model';
import { Record35ObjectService } from './record-35-object.service';
import { Record35ObjectComponent } from './record-35-object.component';
import { Record35ObjectDetailComponent } from './record-35-object-detail.component';
import { Record35ObjectUpdateComponent } from './record-35-object-update.component';
import { Record35ObjectDeletePopupComponent } from './record-35-object-delete-dialog.component';
import { IRecord35Object } from 'app/shared/model/record-35-object.model';

@Injectable({ providedIn: 'root' })
export class Record35ObjectResolve implements Resolve<IRecord35Object> {
    constructor(private service: Record35ObjectService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record35Object: HttpResponse<Record35Object>) => record35Object.body);
        }
        return Observable.of(new Record35Object());
    }
}

export const record35ObjectRoute: Routes = [
    {
        path: 'record-35-object',
        component: Record35ObjectComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-35-object/:id/view',
        component: Record35ObjectDetailComponent,
        resolve: {
            record35Object: Record35ObjectResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-35-object/new',
        component: Record35ObjectUpdateComponent,
        resolve: {
            record35Object: Record35ObjectResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-35-object/:id/edit',
        component: Record35ObjectUpdateComponent,
        resolve: {
            record35Object: Record35ObjectResolve
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
        path: 'record-35-object/:id/delete',
        component: Record35ObjectDeletePopupComponent,
        resolve: {
            record35Object: Record35ObjectResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record35Object.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
