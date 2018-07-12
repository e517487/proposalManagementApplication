import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';
import { Record01StartMySuffixService } from './record-01-start-my-suffix.service';
import { Record01StartMySuffixComponent } from './record-01-start-my-suffix.component';
import { Record01StartMySuffixDetailComponent } from './record-01-start-my-suffix-detail.component';
import { Record01StartMySuffixUpdateComponent } from './record-01-start-my-suffix-update.component';
import { Record01StartMySuffixDeletePopupComponent } from './record-01-start-my-suffix-delete-dialog.component';
import { IRecord01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record01StartMySuffixResolve implements Resolve<IRecord01StartMySuffix> {
    constructor(private service: Record01StartMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record01Start: HttpResponse<Record01StartMySuffix>) => record01Start.body);
        }
        return Observable.of(new Record01StartMySuffix());
    }
}

export const record01StartRoute: Routes = [
    {
        path: 'record-01-start-my-suffix',
        component: Record01StartMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-01-start-my-suffix/:id/view',
        component: Record01StartMySuffixDetailComponent,
        resolve: {
            record01Start: Record01StartMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-01-start-my-suffix/new',
        component: Record01StartMySuffixUpdateComponent,
        resolve: {
            record01Start: Record01StartMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-01-start-my-suffix/:id/edit',
        component: Record01StartMySuffixUpdateComponent,
        resolve: {
            record01Start: Record01StartMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record01StartPopupRoute: Routes = [
    {
        path: 'record-01-start-my-suffix/:id/delete',
        component: Record01StartMySuffixDeletePopupComponent,
        resolve: {
            record01Start: Record01StartMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record01Start.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
