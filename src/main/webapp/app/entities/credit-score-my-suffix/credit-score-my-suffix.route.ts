import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { CreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';
import { CreditScoreMySuffixService } from './credit-score-my-suffix.service';
import { CreditScoreMySuffixComponent } from './credit-score-my-suffix.component';
import { CreditScoreMySuffixDetailComponent } from './credit-score-my-suffix-detail.component';
import { CreditScoreMySuffixUpdateComponent } from './credit-score-my-suffix-update.component';
import { CreditScoreMySuffixDeletePopupComponent } from './credit-score-my-suffix-delete-dialog.component';
import { ICreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class CreditScoreMySuffixResolve implements Resolve<ICreditScoreMySuffix> {
    constructor(private service: CreditScoreMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((creditScore: HttpResponse<CreditScoreMySuffix>) => creditScore.body);
        }
        return Observable.of(new CreditScoreMySuffix());
    }
}

export const creditScoreRoute: Routes = [
    {
        path: 'credit-score-my-suffix',
        component: CreditScoreMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.creditScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'credit-score-my-suffix/:id/view',
        component: CreditScoreMySuffixDetailComponent,
        resolve: {
            creditScore: CreditScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.creditScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'credit-score-my-suffix/new',
        component: CreditScoreMySuffixUpdateComponent,
        resolve: {
            creditScore: CreditScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.creditScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'credit-score-my-suffix/:id/edit',
        component: CreditScoreMySuffixUpdateComponent,
        resolve: {
            creditScore: CreditScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.creditScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const creditScorePopupRoute: Routes = [
    {
        path: 'credit-score-my-suffix/:id/delete',
        component: CreditScoreMySuffixDeletePopupComponent,
        resolve: {
            creditScore: CreditScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.creditScore.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
