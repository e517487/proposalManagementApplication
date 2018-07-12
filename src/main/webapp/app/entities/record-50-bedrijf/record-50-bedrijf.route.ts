import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';
import { Record50BedrijfService } from './record-50-bedrijf.service';
import { Record50BedrijfComponent } from './record-50-bedrijf.component';
import { Record50BedrijfDetailComponent } from './record-50-bedrijf-detail.component';
import { Record50BedrijfUpdateComponent } from './record-50-bedrijf-update.component';
import { Record50BedrijfDeletePopupComponent } from './record-50-bedrijf-delete-dialog.component';
import { IRecord50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';

@Injectable({ providedIn: 'root' })
export class Record50BedrijfResolve implements Resolve<IRecord50Bedrijf> {
    constructor(private service: Record50BedrijfService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record50Bedrijf: HttpResponse<Record50Bedrijf>) => record50Bedrijf.body);
        }
        return Observable.of(new Record50Bedrijf());
    }
}

export const record50BedrijfRoute: Routes = [
    {
        path: 'record-50-bedrijf',
        component: Record50BedrijfComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-50-bedrijf/:id/view',
        component: Record50BedrijfDetailComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-50-bedrijf/new',
        component: Record50BedrijfUpdateComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-50-bedrijf/:id/edit',
        component: Record50BedrijfUpdateComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record50BedrijfPopupRoute: Routes = [
    {
        path: 'record-50-bedrijf/:id/delete',
        component: Record50BedrijfDeletePopupComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
