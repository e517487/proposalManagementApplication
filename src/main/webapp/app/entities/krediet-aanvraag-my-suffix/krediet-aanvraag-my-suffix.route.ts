import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { KredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';
import { KredietAanvraagMySuffixService } from './krediet-aanvraag-my-suffix.service';
import { KredietAanvraagMySuffixComponent } from './krediet-aanvraag-my-suffix.component';
import { KredietAanvraagMySuffixDetailComponent } from './krediet-aanvraag-my-suffix-detail.component';
import { KredietAanvraagMySuffixUpdateComponent } from './krediet-aanvraag-my-suffix-update.component';
import { KredietAanvraagMySuffixDeletePopupComponent } from './krediet-aanvraag-my-suffix-delete-dialog.component';
import { IKredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class KredietAanvraagMySuffixResolve implements Resolve<IKredietAanvraagMySuffix> {
    constructor(private service: KredietAanvraagMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((kredietAanvraag: HttpResponse<KredietAanvraagMySuffix>) => kredietAanvraag.body);
        }
        return Observable.of(new KredietAanvraagMySuffix());
    }
}

export const kredietAanvraagRoute: Routes = [
    {
        path: 'krediet-aanvraag-my-suffix',
        component: KredietAanvraagMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.kredietAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'krediet-aanvraag-my-suffix/:id/view',
        component: KredietAanvraagMySuffixDetailComponent,
        resolve: {
            kredietAanvraag: KredietAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.kredietAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'krediet-aanvraag-my-suffix/new',
        component: KredietAanvraagMySuffixUpdateComponent,
        resolve: {
            kredietAanvraag: KredietAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.kredietAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'krediet-aanvraag-my-suffix/:id/edit',
        component: KredietAanvraagMySuffixUpdateComponent,
        resolve: {
            kredietAanvraag: KredietAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.kredietAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const kredietAanvraagPopupRoute: Routes = [
    {
        path: 'krediet-aanvraag-my-suffix/:id/delete',
        component: KredietAanvraagMySuffixDeletePopupComponent,
        resolve: {
            kredietAanvraag: KredietAanvraagMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.kredietAanvraag.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
