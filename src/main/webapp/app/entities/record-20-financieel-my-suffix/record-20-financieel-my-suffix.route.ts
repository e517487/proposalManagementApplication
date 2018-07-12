import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';
import { Record20FinancieelMySuffixService } from './record-20-financieel-my-suffix.service';
import { Record20FinancieelMySuffixComponent } from './record-20-financieel-my-suffix.component';
import { Record20FinancieelMySuffixDetailComponent } from './record-20-financieel-my-suffix-detail.component';
import { Record20FinancieelMySuffixUpdateComponent } from './record-20-financieel-my-suffix-update.component';
import { Record20FinancieelMySuffixDeletePopupComponent } from './record-20-financieel-my-suffix-delete-dialog.component';
import { IRecord20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record20FinancieelMySuffixResolve implements Resolve<IRecord20FinancieelMySuffix> {
    constructor(private service: Record20FinancieelMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record20Financieel: HttpResponse<Record20FinancieelMySuffix>) => record20Financieel.body);
        }
        return Observable.of(new Record20FinancieelMySuffix());
    }
}

export const record20FinancieelRoute: Routes = [
    {
        path: 'record-20-financieel-my-suffix',
        component: Record20FinancieelMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-20-financieel-my-suffix/:id/view',
        component: Record20FinancieelMySuffixDetailComponent,
        resolve: {
            record20Financieel: Record20FinancieelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-20-financieel-my-suffix/new',
        component: Record20FinancieelMySuffixUpdateComponent,
        resolve: {
            record20Financieel: Record20FinancieelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-20-financieel-my-suffix/:id/edit',
        component: Record20FinancieelMySuffixUpdateComponent,
        resolve: {
            record20Financieel: Record20FinancieelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record20FinancieelPopupRoute: Routes = [
    {
        path: 'record-20-financieel-my-suffix/:id/delete',
        component: Record20FinancieelMySuffixDeletePopupComponent,
        resolve: {
            record20Financieel: Record20FinancieelMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
