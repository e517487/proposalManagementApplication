import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';
import { Record30InruilMySuffixService } from './record-30-inruil-my-suffix.service';
import { Record30InruilMySuffixComponent } from './record-30-inruil-my-suffix.component';
import { Record30InruilMySuffixDetailComponent } from './record-30-inruil-my-suffix-detail.component';
import { Record30InruilMySuffixUpdateComponent } from './record-30-inruil-my-suffix-update.component';
import { Record30InruilMySuffixDeletePopupComponent } from './record-30-inruil-my-suffix-delete-dialog.component';
import { IRecord30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record30InruilMySuffixResolve implements Resolve<IRecord30InruilMySuffix> {
    constructor(private service: Record30InruilMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record30Inruil: HttpResponse<Record30InruilMySuffix>) => record30Inruil.body);
        }
        return Observable.of(new Record30InruilMySuffix());
    }
}

export const record30InruilRoute: Routes = [
    {
        path: 'record-30-inruil-my-suffix',
        component: Record30InruilMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-30-inruil-my-suffix/:id/view',
        component: Record30InruilMySuffixDetailComponent,
        resolve: {
            record30Inruil: Record30InruilMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-30-inruil-my-suffix/new',
        component: Record30InruilMySuffixUpdateComponent,
        resolve: {
            record30Inruil: Record30InruilMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-30-inruil-my-suffix/:id/edit',
        component: Record30InruilMySuffixUpdateComponent,
        resolve: {
            record30Inruil: Record30InruilMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record30InruilPopupRoute: Routes = [
    {
        path: 'record-30-inruil-my-suffix/:id/delete',
        component: Record30InruilMySuffixDeletePopupComponent,
        resolve: {
            record30Inruil: Record30InruilMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record30Inruil.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
