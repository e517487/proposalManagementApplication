import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';
import { Record10AanvraagGegevensAlgemeenService } from './record-10-aanvraag-gegevens-algemeen.service';
import { Record10AanvraagGegevensAlgemeenComponent } from './record-10-aanvraag-gegevens-algemeen.component';
import { Record10AanvraagGegevensAlgemeenDetailComponent } from './record-10-aanvraag-gegevens-algemeen-detail.component';
import { Record10AanvraagGegevensAlgemeenUpdateComponent } from './record-10-aanvraag-gegevens-algemeen-update.component';
import { Record10AanvraagGegevensAlgemeenDeletePopupComponent } from './record-10-aanvraag-gegevens-algemeen-delete-dialog.component';
import { IRecord10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';

@Injectable({ providedIn: 'root' })
export class Record10AanvraagGegevensAlgemeenResolve implements Resolve<IRecord10AanvraagGegevensAlgemeen> {
    constructor(private service: Record10AanvraagGegevensAlgemeenService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map(
                    (record10AanvraagGegevensAlgemeen: HttpResponse<Record10AanvraagGegevensAlgemeen>) =>
                        record10AanvraagGegevensAlgemeen.body
                );
        }
        return Observable.of(new Record10AanvraagGegevensAlgemeen());
    }
}

export const record10AanvraagGegevensAlgemeenRoute: Routes = [
    {
        path: 'record-10-aanvraag-gegevens-algemeen',
        component: Record10AanvraagGegevensAlgemeenComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-10-aanvraag-gegevens-algemeen/:id/view',
        component: Record10AanvraagGegevensAlgemeenDetailComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-10-aanvraag-gegevens-algemeen/new',
        component: Record10AanvraagGegevensAlgemeenUpdateComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-10-aanvraag-gegevens-algemeen/:id/edit',
        component: Record10AanvraagGegevensAlgemeenUpdateComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record10AanvraagGegevensAlgemeenPopupRoute: Routes = [
    {
        path: 'record-10-aanvraag-gegevens-algemeen/:id/delete',
        component: Record10AanvraagGegevensAlgemeenDeletePopupComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
