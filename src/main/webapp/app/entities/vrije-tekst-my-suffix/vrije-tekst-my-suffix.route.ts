import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { VrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';
import { VrijeTekstMySuffixService } from './vrije-tekst-my-suffix.service';
import { VrijeTekstMySuffixComponent } from './vrije-tekst-my-suffix.component';
import { VrijeTekstMySuffixDetailComponent } from './vrije-tekst-my-suffix-detail.component';
import { VrijeTekstMySuffixUpdateComponent } from './vrije-tekst-my-suffix-update.component';
import { VrijeTekstMySuffixDeletePopupComponent } from './vrije-tekst-my-suffix-delete-dialog.component';
import { IVrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class VrijeTekstMySuffixResolve implements Resolve<IVrijeTekstMySuffix> {
    constructor(private service: VrijeTekstMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((vrijeTekst: HttpResponse<VrijeTekstMySuffix>) => vrijeTekst.body);
        }
        return Observable.of(new VrijeTekstMySuffix());
    }
}

export const vrijeTekstRoute: Routes = [
    {
        path: 'vrije-tekst-my-suffix',
        component: VrijeTekstMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.vrijeTekst.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'vrije-tekst-my-suffix/:id/view',
        component: VrijeTekstMySuffixDetailComponent,
        resolve: {
            vrijeTekst: VrijeTekstMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.vrijeTekst.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'vrije-tekst-my-suffix/new',
        component: VrijeTekstMySuffixUpdateComponent,
        resolve: {
            vrijeTekst: VrijeTekstMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.vrijeTekst.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'vrije-tekst-my-suffix/:id/edit',
        component: VrijeTekstMySuffixUpdateComponent,
        resolve: {
            vrijeTekst: VrijeTekstMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.vrijeTekst.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const vrijeTekstPopupRoute: Routes = [
    {
        path: 'vrije-tekst-my-suffix/:id/delete',
        component: VrijeTekstMySuffixDeletePopupComponent,
        resolve: {
            vrijeTekst: VrijeTekstMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.vrijeTekst.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
