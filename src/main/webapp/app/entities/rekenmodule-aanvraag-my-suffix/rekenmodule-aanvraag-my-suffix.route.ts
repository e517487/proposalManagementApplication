import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { RekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';
import { RekenmoduleAanvraagMySuffixService } from './rekenmodule-aanvraag-my-suffix.service';
import { RekenmoduleAanvraagMySuffixComponent } from './rekenmodule-aanvraag-my-suffix.component';
import { RekenmoduleAanvraagMySuffixDetailComponent } from './rekenmodule-aanvraag-my-suffix-detail.component';
import { RekenmoduleAanvraagMySuffixUpdateComponent } from './rekenmodule-aanvraag-my-suffix-update.component';
import { RekenmoduleAanvraagMySuffixDeletePopupComponent } from './rekenmodule-aanvraag-my-suffix-delete-dialog.component';
import { IRekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class RekenmoduleAanvraagMySuffixResolve implements Resolve<IRekenmoduleAanvraagMySuffix> {
    constructor(private service: RekenmoduleAanvraagMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((rekenmoduleAanvraag: HttpResponse<RekenmoduleAanvraagMySuffix>) => rekenmoduleAanvraag.body);
        }
        return Observable.of(new RekenmoduleAanvraagMySuffix());
    }
}

export const rekenmoduleAanvraagRoute: Routes = [
    {
        path: 'rekenmodule-aanvraag-my-suffix',
        component: RekenmoduleAanvraagMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.rekenmoduleAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'rekenmodule-aanvraag-my-suffix/:id/view',
        component: RekenmoduleAanvraagMySuffixDetailComponent,
        resolve: {
            rekenmoduleAanvraag: RekenmoduleAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.rekenmoduleAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'rekenmodule-aanvraag-my-suffix/new',
        component: RekenmoduleAanvraagMySuffixUpdateComponent,
        resolve: {
            rekenmoduleAanvraag: RekenmoduleAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.rekenmoduleAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'rekenmodule-aanvraag-my-suffix/:id/edit',
        component: RekenmoduleAanvraagMySuffixUpdateComponent,
        resolve: {
            rekenmoduleAanvraag: RekenmoduleAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.rekenmoduleAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const rekenmoduleAanvraagPopupRoute: Routes = [
    {
        path: 'rekenmodule-aanvraag-my-suffix/:id/delete',
        component: RekenmoduleAanvraagMySuffixDeletePopupComponent,
        resolve: {
            rekenmoduleAanvraag: RekenmoduleAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.rekenmoduleAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
