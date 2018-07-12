import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record30Inruil } from 'app/shared/model/record-30-inruil.model';
import { Record30InruilService } from './record-30-inruil.service';
import { Record30InruilComponent } from './record-30-inruil.component';
import { Record30InruilDetailComponent } from './record-30-inruil-detail.component';
import { Record30InruilUpdateComponent } from './record-30-inruil-update.component';
import { Record30InruilDeletePopupComponent } from './record-30-inruil-delete-dialog.component';
import { IRecord30Inruil } from 'app/shared/model/record-30-inruil.model';

@Injectable({ providedIn: 'root' })
export class Record30InruilResolve implements Resolve<IRecord30Inruil> {
    constructor(private service: Record30InruilService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record30Inruil: HttpResponse<Record30Inruil>) => record30Inruil.body);
        }
        return Observable.of(new Record30Inruil());
    }
}

export const record30InruilRoute: Routes = [
    {
        path: 'record-30-inruil',
        component: Record30InruilComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-30-inruil/:id/view',
        component: Record30InruilDetailComponent,
        resolve: {
            record30Inruil: Record30InruilResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-30-inruil/new',
        component: Record30InruilUpdateComponent,
        resolve: {
            record30Inruil: Record30InruilResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-30-inruil/:id/edit',
        component: Record30InruilUpdateComponent,
        resolve: {
            record30Inruil: Record30InruilResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record30InruilPopupRoute: Routes = [
    {
        path: 'record-30-inruil/:id/delete',
        component: Record30InruilDeletePopupComponent,
        resolve: {
            record30Inruil: Record30InruilResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
