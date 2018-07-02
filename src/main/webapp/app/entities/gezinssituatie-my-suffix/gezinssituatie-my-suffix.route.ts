import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { GezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';
import { GezinssituatieMySuffixService } from './gezinssituatie-my-suffix.service';
import { GezinssituatieMySuffixComponent } from './gezinssituatie-my-suffix.component';
import { GezinssituatieMySuffixDetailComponent } from './gezinssituatie-my-suffix-detail.component';
import { GezinssituatieMySuffixUpdateComponent } from './gezinssituatie-my-suffix-update.component';
import { GezinssituatieMySuffixDeletePopupComponent } from './gezinssituatie-my-suffix-delete-dialog.component';
import { IGezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class GezinssituatieMySuffixResolve implements Resolve<IGezinssituatieMySuffix> {
    constructor(private service: GezinssituatieMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((gezinssituatie: HttpResponse<GezinssituatieMySuffix>) => gezinssituatie.body);
        }
        return Observable.of(new GezinssituatieMySuffix());
    }
}

export const gezinssituatieRoute: Routes = [
    {
        path: 'gezinssituatie-my-suffix',
        component: GezinssituatieMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.gezinssituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'gezinssituatie-my-suffix/:id/view',
        component: GezinssituatieMySuffixDetailComponent,
        resolve: {
            gezinssituatie: GezinssituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.gezinssituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'gezinssituatie-my-suffix/new',
        component: GezinssituatieMySuffixUpdateComponent,
        resolve: {
            gezinssituatie: GezinssituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.gezinssituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'gezinssituatie-my-suffix/:id/edit',
        component: GezinssituatieMySuffixUpdateComponent,
        resolve: {
            gezinssituatie: GezinssituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.gezinssituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const gezinssituatiePopupRoute: Routes = [
    {
        path: 'gezinssituatie-my-suffix/:id/delete',
        component: GezinssituatieMySuffixDeletePopupComponent,
        resolve: {
            gezinssituatie: GezinssituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.gezinssituatie.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
