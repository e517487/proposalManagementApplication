import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';
import { Record50BedrijfMySuffixService } from './record-50-bedrijf-my-suffix.service';
import { Record50BedrijfMySuffixComponent } from './record-50-bedrijf-my-suffix.component';
import { Record50BedrijfMySuffixDetailComponent } from './record-50-bedrijf-my-suffix-detail.component';
import { Record50BedrijfMySuffixUpdateComponent } from './record-50-bedrijf-my-suffix-update.component';
import { Record50BedrijfMySuffixDeletePopupComponent } from './record-50-bedrijf-my-suffix-delete-dialog.component';
import { IRecord50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record50BedrijfMySuffixResolve implements Resolve<IRecord50BedrijfMySuffix> {
    constructor(private service: Record50BedrijfMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record50Bedrijf: HttpResponse<Record50BedrijfMySuffix>) => record50Bedrijf.body);
        }
        return Observable.of(new Record50BedrijfMySuffix());
    }
}

export const record50BedrijfRoute: Routes = [
    {
        path: 'record-50-bedrijf-my-suffix',
        component: Record50BedrijfMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-50-bedrijf-my-suffix/:id/view',
        component: Record50BedrijfMySuffixDetailComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-50-bedrijf-my-suffix/new',
        component: Record50BedrijfMySuffixUpdateComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-50-bedrijf-my-suffix/:id/edit',
        component: Record50BedrijfMySuffixUpdateComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record50BedrijfPopupRoute: Routes = [
    {
        path: 'record-50-bedrijf-my-suffix/:id/delete',
        component: Record50BedrijfMySuffixDeletePopupComponent,
        resolve: {
            record50Bedrijf: Record50BedrijfMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record50Bedrijf.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
