import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';
import { Record62UitlegMySuffixService } from './record-62-uitleg-my-suffix.service';
import { Record62UitlegMySuffixComponent } from './record-62-uitleg-my-suffix.component';
import { Record62UitlegMySuffixDetailComponent } from './record-62-uitleg-my-suffix-detail.component';
import { Record62UitlegMySuffixUpdateComponent } from './record-62-uitleg-my-suffix-update.component';
import { Record62UitlegMySuffixDeletePopupComponent } from './record-62-uitleg-my-suffix-delete-dialog.component';
import { IRecord62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record62UitlegMySuffixResolve implements Resolve<IRecord62UitlegMySuffix> {
    constructor(private service: Record62UitlegMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record62Uitleg: HttpResponse<Record62UitlegMySuffix>) => record62Uitleg.body);
        }
        return Observable.of(new Record62UitlegMySuffix());
    }
}

export const record62UitlegRoute: Routes = [
    {
        path: 'record-62-uitleg-my-suffix',
        component: Record62UitlegMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-62-uitleg-my-suffix/:id/view',
        component: Record62UitlegMySuffixDetailComponent,
        resolve: {
            record62Uitleg: Record62UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-62-uitleg-my-suffix/new',
        component: Record62UitlegMySuffixUpdateComponent,
        resolve: {
            record62Uitleg: Record62UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-62-uitleg-my-suffix/:id/edit',
        component: Record62UitlegMySuffixUpdateComponent,
        resolve: {
            record62Uitleg: Record62UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record62UitlegPopupRoute: Routes = [
    {
        path: 'record-62-uitleg-my-suffix/:id/delete',
        component: Record62UitlegMySuffixDeletePopupComponent,
        resolve: {
            record62Uitleg: Record62UitlegMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record62Uitleg.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
