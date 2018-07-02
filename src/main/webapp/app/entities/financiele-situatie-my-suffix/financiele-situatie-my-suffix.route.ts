import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { FinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';
import { FinancieleSituatieMySuffixService } from './financiele-situatie-my-suffix.service';
import { FinancieleSituatieMySuffixComponent } from './financiele-situatie-my-suffix.component';
import { FinancieleSituatieMySuffixDetailComponent } from './financiele-situatie-my-suffix-detail.component';
import { FinancieleSituatieMySuffixUpdateComponent } from './financiele-situatie-my-suffix-update.component';
import { FinancieleSituatieMySuffixDeletePopupComponent } from './financiele-situatie-my-suffix-delete-dialog.component';
import { IFinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class FinancieleSituatieMySuffixResolve implements Resolve<IFinancieleSituatieMySuffix> {
    constructor(private service: FinancieleSituatieMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((financieleSituatie: HttpResponse<FinancieleSituatieMySuffix>) => financieleSituatie.body);
        }
        return Observable.of(new FinancieleSituatieMySuffix());
    }
}

export const financieleSituatieRoute: Routes = [
    {
        path: 'financiele-situatie-my-suffix',
        component: FinancieleSituatieMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.financieleSituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'financiele-situatie-my-suffix/:id/view',
        component: FinancieleSituatieMySuffixDetailComponent,
        resolve: {
            financieleSituatie: FinancieleSituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.financieleSituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'financiele-situatie-my-suffix/new',
        component: FinancieleSituatieMySuffixUpdateComponent,
        resolve: {
            financieleSituatie: FinancieleSituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.financieleSituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'financiele-situatie-my-suffix/:id/edit',
        component: FinancieleSituatieMySuffixUpdateComponent,
        resolve: {
            financieleSituatie: FinancieleSituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.financieleSituatie.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const financieleSituatiePopupRoute: Routes = [
    {
        path: 'financiele-situatie-my-suffix/:id/delete',
        component: FinancieleSituatieMySuffixDeletePopupComponent,
        resolve: {
            financieleSituatie: FinancieleSituatieMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.financieleSituatie.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
