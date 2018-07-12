import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';
import { Record11AanvraagGegevensOpmerkingenService } from './record-11-aanvraag-gegevens-opmerkingen.service';
import { Record11AanvraagGegevensOpmerkingenComponent } from './record-11-aanvraag-gegevens-opmerkingen.component';
import { Record11AanvraagGegevensOpmerkingenDetailComponent } from './record-11-aanvraag-gegevens-opmerkingen-detail.component';
import { Record11AanvraagGegevensOpmerkingenUpdateComponent } from './record-11-aanvraag-gegevens-opmerkingen-update.component';
import { Record11AanvraagGegevensOpmerkingenDeletePopupComponent } from './record-11-aanvraag-gegevens-opmerkingen-delete-dialog.component';
import { IRecord11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';

@Injectable({ providedIn: 'root' })
export class Record11AanvraagGegevensOpmerkingenResolve implements Resolve<IRecord11AanvraagGegevensOpmerkingen> {
    constructor(private service: Record11AanvraagGegevensOpmerkingenService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map(
                    (record11AanvraagGegevensOpmerkingen: HttpResponse<Record11AanvraagGegevensOpmerkingen>) =>
                        record11AanvraagGegevensOpmerkingen.body
                );
        }
        return Observable.of(new Record11AanvraagGegevensOpmerkingen());
    }
}

export const record11AanvraagGegevensOpmerkingenRoute: Routes = [
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen',
        component: Record11AanvraagGegevensOpmerkingenComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen/:id/view',
        component: Record11AanvraagGegevensOpmerkingenDetailComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen/new',
        component: Record11AanvraagGegevensOpmerkingenUpdateComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen/:id/edit',
        component: Record11AanvraagGegevensOpmerkingenUpdateComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record11AanvraagGegevensOpmerkingenPopupRoute: Routes = [
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen/:id/delete',
        component: Record11AanvraagGegevensOpmerkingenDeletePopupComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
