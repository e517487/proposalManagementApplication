import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';
import { Record25HerfinancieeringService } from './record-25-herfinancieering.service';
import { Record25HerfinancieeringComponent } from './record-25-herfinancieering.component';
import { Record25HerfinancieeringDetailComponent } from './record-25-herfinancieering-detail.component';
import { Record25HerfinancieeringUpdateComponent } from './record-25-herfinancieering-update.component';
import { Record25HerfinancieeringDeletePopupComponent } from './record-25-herfinancieering-delete-dialog.component';
import { IRecord25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';

@Injectable({ providedIn: 'root' })
export class Record25HerfinancieeringResolve implements Resolve<IRecord25Herfinancieering> {
    constructor(private service: Record25HerfinancieeringService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map((record25Herfinancieering: HttpResponse<Record25Herfinancieering>) => record25Herfinancieering.body);
        }
        return Observable.of(new Record25Herfinancieering());
    }
}

export const record25HerfinancieeringRoute: Routes = [
    {
        path: 'record-25-herfinancieering',
        component: Record25HerfinancieeringComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-25-herfinancieering/:id/view',
        component: Record25HerfinancieeringDetailComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-25-herfinancieering/new',
        component: Record25HerfinancieeringUpdateComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-25-herfinancieering/:id/edit',
        component: Record25HerfinancieeringUpdateComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record25HerfinancieeringPopupRoute: Routes = [
    {
        path: 'record-25-herfinancieering/:id/delete',
        component: Record25HerfinancieeringDeletePopupComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
