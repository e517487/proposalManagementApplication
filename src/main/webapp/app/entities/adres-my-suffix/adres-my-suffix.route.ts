import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { AdresMySuffix } from 'app/shared/model/adres-my-suffix.model';
import { AdresMySuffixService } from './adres-my-suffix.service';
import { AdresMySuffixComponent } from './adres-my-suffix.component';
import { AdresMySuffixDetailComponent } from './adres-my-suffix-detail.component';
import { AdresMySuffixUpdateComponent } from './adres-my-suffix-update.component';
import { AdresMySuffixDeletePopupComponent } from './adres-my-suffix-delete-dialog.component';
import { IAdresMySuffix } from 'app/shared/model/adres-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class AdresMySuffixResolve implements Resolve<IAdresMySuffix> {
    constructor(private service: AdresMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((adres: HttpResponse<AdresMySuffix>) => adres.body);
        }
        return Observable.of(new AdresMySuffix());
    }
}

export const adresRoute: Routes = [
    {
        path: 'adres-my-suffix',
        component: AdresMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.adres.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'adres-my-suffix/:id/view',
        component: AdresMySuffixDetailComponent,
        resolve: {
            adres: AdresMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.adres.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'adres-my-suffix/new',
        component: AdresMySuffixUpdateComponent,
        resolve: {
            adres: AdresMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.adres.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'adres-my-suffix/:id/edit',
        component: AdresMySuffixUpdateComponent,
        resolve: {
            adres: AdresMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.adres.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const adresPopupRoute: Routes = [
    {
        path: 'adres-my-suffix/:id/delete',
        component: AdresMySuffixDeletePopupComponent,
        resolve: {
            adres: AdresMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.adres.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
