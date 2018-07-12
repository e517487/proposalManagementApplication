import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record20Financieel } from 'app/shared/model/record-20-financieel.model';
import { Record20FinancieelService } from './record-20-financieel.service';
import { Record20FinancieelComponent } from './record-20-financieel.component';
import { Record20FinancieelDetailComponent } from './record-20-financieel-detail.component';
import { Record20FinancieelUpdateComponent } from './record-20-financieel-update.component';
import { Record20FinancieelDeletePopupComponent } from './record-20-financieel-delete-dialog.component';
import { IRecord20Financieel } from 'app/shared/model/record-20-financieel.model';

@Injectable({ providedIn: 'root' })
export class Record20FinancieelResolve implements Resolve<IRecord20Financieel> {
    constructor(private service: Record20FinancieelService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record20Financieel: HttpResponse<Record20Financieel>) => record20Financieel.body);
        }
        return Observable.of(new Record20Financieel());
    }
}

export const record20FinancieelRoute: Routes = [
    {
        path: 'record-20-financieel',
        component: Record20FinancieelComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-20-financieel/:id/view',
        component: Record20FinancieelDetailComponent,
        resolve: {
            record20Financieel: Record20FinancieelResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-20-financieel/new',
        component: Record20FinancieelUpdateComponent,
        resolve: {
            record20Financieel: Record20FinancieelResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-20-financieel/:id/edit',
        component: Record20FinancieelUpdateComponent,
        resolve: {
            record20Financieel: Record20FinancieelResolve
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
        path: 'record-20-financieel/:id/delete',
        component: Record20FinancieelDeletePopupComponent,
        resolve: {
            record20Financieel: Record20FinancieelResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record20Financieel.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
