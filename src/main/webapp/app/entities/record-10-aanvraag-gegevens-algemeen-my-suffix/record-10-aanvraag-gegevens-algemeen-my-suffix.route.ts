import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';
import { Record10AanvraagGegevensAlgemeenMySuffixService } from './record-10-aanvraag-gegevens-algemeen-my-suffix.service';
import { Record10AanvraagGegevensAlgemeenMySuffixComponent } from './record-10-aanvraag-gegevens-algemeen-my-suffix.component';
import { Record10AanvraagGegevensAlgemeenMySuffixDetailComponent } from './record-10-aanvraag-gegevens-algemeen-my-suffix-detail.component';
import { Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent } from './record-10-aanvraag-gegevens-algemeen-my-suffix-update.component';
import { Record10AanvraagGegevensAlgemeenMySuffixDeletePopupComponent } from './record-10-aanvraag-gegevens-algemeen-my-suffix-delete-dialog.component';
import { IRecord10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record10AanvraagGegevensAlgemeenMySuffixResolve implements Resolve<IRecord10AanvraagGegevensAlgemeenMySuffix> {
    constructor(private service: Record10AanvraagGegevensAlgemeenMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map(
                    (record10AanvraagGegevensAlgemeen: HttpResponse<Record10AanvraagGegevensAlgemeenMySuffix>) =>
                        record10AanvraagGegevensAlgemeen.body
                );
        }
        return Observable.of(new Record10AanvraagGegevensAlgemeenMySuffix());
    }
}

export const record10AanvraagGegevensAlgemeenRoute: Routes = [
    {
        path: 'record-10-aanvraag-gegevens-algemeen-my-suffix',
        component: Record10AanvraagGegevensAlgemeenMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-10-aanvraag-gegevens-algemeen-my-suffix/:id/view',
        component: Record10AanvraagGegevensAlgemeenMySuffixDetailComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-10-aanvraag-gegevens-algemeen-my-suffix/new',
        component: Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-10-aanvraag-gegevens-algemeen-my-suffix/:id/edit',
        component: Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenMySuffixResolve
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
        path: 'record-10-aanvraag-gegevens-algemeen-my-suffix/:id/delete',
        component: Record10AanvraagGegevensAlgemeenMySuffixDeletePopupComponent,
        resolve: {
            record10AanvraagGegevensAlgemeen: Record10AanvraagGegevensAlgemeenMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record10AanvraagGegevensAlgemeen.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
