import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';
import { Record11AanvraagGegevensOpmerkingenMySuffixComponent } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix.component';
import { Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix-detail.component';
import { Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix-update.component';
import { Record11AanvraagGegevensOpmerkingenMySuffixDeletePopupComponent } from './record-11-aanvraag-gegevens-opmerkingen-my-suffix-delete-dialog.component';
import { IRecord11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record11AanvraagGegevensOpmerkingenMySuffixResolve implements Resolve<IRecord11AanvraagGegevensOpmerkingenMySuffix> {
    constructor(private service: Record11AanvraagGegevensOpmerkingenMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map(
                    (record11AanvraagGegevensOpmerkingen: HttpResponse<Record11AanvraagGegevensOpmerkingenMySuffix>) =>
                        record11AanvraagGegevensOpmerkingen.body
                );
        }
        return Observable.of(new Record11AanvraagGegevensOpmerkingenMySuffix());
    }
}

export const record11AanvraagGegevensOpmerkingenRoute: Routes = [
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen-my-suffix',
        component: Record11AanvraagGegevensOpmerkingenMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen-my-suffix/:id/view',
        component: Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen-my-suffix/new',
        component: Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-11-aanvraag-gegevens-opmerkingen-my-suffix/:id/edit',
        component: Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenMySuffixResolve
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
        path: 'record-11-aanvraag-gegevens-opmerkingen-my-suffix/:id/delete',
        component: Record11AanvraagGegevensOpmerkingenMySuffixDeletePopupComponent,
        resolve: {
            record11AanvraagGegevensOpmerkingen: Record11AanvraagGegevensOpmerkingenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record11AanvraagGegevensOpmerkingen.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
