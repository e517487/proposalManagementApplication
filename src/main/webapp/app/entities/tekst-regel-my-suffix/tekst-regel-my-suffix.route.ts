import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { TekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';
import { TekstRegelMySuffixService } from './tekst-regel-my-suffix.service';
import { TekstRegelMySuffixComponent } from './tekst-regel-my-suffix.component';
import { TekstRegelMySuffixDetailComponent } from './tekst-regel-my-suffix-detail.component';
import { TekstRegelMySuffixUpdateComponent } from './tekst-regel-my-suffix-update.component';
import { TekstRegelMySuffixDeletePopupComponent } from './tekst-regel-my-suffix-delete-dialog.component';
import { ITekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class TekstRegelMySuffixResolve implements Resolve<ITekstRegelMySuffix> {
    constructor(private service: TekstRegelMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((tekstRegel: HttpResponse<TekstRegelMySuffix>) => tekstRegel.body);
        }
        return Observable.of(new TekstRegelMySuffix());
    }
}

export const tekstRegelRoute: Routes = [
    {
        path: 'tekst-regel-my-suffix',
        component: TekstRegelMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.tekstRegel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tekst-regel-my-suffix/:id/view',
        component: TekstRegelMySuffixDetailComponent,
        resolve: {
            tekstRegel: TekstRegelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.tekstRegel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tekst-regel-my-suffix/new',
        component: TekstRegelMySuffixUpdateComponent,
        resolve: {
            tekstRegel: TekstRegelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.tekstRegel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tekst-regel-my-suffix/:id/edit',
        component: TekstRegelMySuffixUpdateComponent,
        resolve: {
            tekstRegel: TekstRegelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.tekstRegel.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const tekstRegelPopupRoute: Routes = [
    {
        path: 'tekst-regel-my-suffix/:id/delete',
        component: TekstRegelMySuffixDeletePopupComponent,
        resolve: {
            tekstRegel: TekstRegelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.tekstRegel.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
