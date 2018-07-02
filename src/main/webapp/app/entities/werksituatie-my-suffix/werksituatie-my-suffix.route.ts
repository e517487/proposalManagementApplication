import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { WerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';
import { WerksituatieMySuffixService } from './werksituatie-my-suffix.service';
import { WerksituatieMySuffixComponent } from './werksituatie-my-suffix.component';
import { WerksituatieMySuffixDetailComponent } from './werksituatie-my-suffix-detail.component';
import { WerksituatieMySuffixUpdateComponent } from './werksituatie-my-suffix-update.component';
import { WerksituatieMySuffixDeletePopupComponent } from './werksituatie-my-suffix-delete-dialog.component';
import { IWerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class WerksituatieMySuffixResolve implements Resolve<IWerksituatieMySuffix> {
    constructor(private service: WerksituatieMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((werksituatie: HttpResponse<WerksituatieMySuffix>) => werksituatie.body);
        }
        return Observable.of(new WerksituatieMySuffix());
    }
}

export const werksituatieRoute: Routes = [
    {
        path: 'werksituatie-my-suffix',
        component: WerksituatieMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.werksituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'werksituatie-my-suffix/:id/view',
        component: WerksituatieMySuffixDetailComponent,
        resolve: {
            werksituatie: WerksituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.werksituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'werksituatie-my-suffix/new',
        component: WerksituatieMySuffixUpdateComponent,
        resolve: {
            werksituatie: WerksituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.werksituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'werksituatie-my-suffix/:id/edit',
        component: WerksituatieMySuffixUpdateComponent,
        resolve: {
            werksituatie: WerksituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.werksituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const werksituatiePopupRoute: Routes = [
    {
        path: 'werksituatie-my-suffix/:id/delete',
        component: WerksituatieMySuffixDeletePopupComponent,
        resolve: {
            werksituatie: WerksituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.werksituatie.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
