import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';
import { Record25HerfinancieeringMySuffixService } from './record-25-herfinancieering-my-suffix.service';
import { Record25HerfinancieeringMySuffixComponent } from './record-25-herfinancieering-my-suffix.component';
import { Record25HerfinancieeringMySuffixDetailComponent } from './record-25-herfinancieering-my-suffix-detail.component';
import { Record25HerfinancieeringMySuffixUpdateComponent } from './record-25-herfinancieering-my-suffix-update.component';
import { Record25HerfinancieeringMySuffixDeletePopupComponent } from './record-25-herfinancieering-my-suffix-delete-dialog.component';
import { IRecord25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record25HerfinancieeringMySuffixResolve implements Resolve<IRecord25HerfinancieeringMySuffix> {
    constructor(private service: Record25HerfinancieeringMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map((record25Herfinancieering: HttpResponse<Record25HerfinancieeringMySuffix>) => record25Herfinancieering.body);
        }
        return Observable.of(new Record25HerfinancieeringMySuffix());
    }
}

export const record25HerfinancieeringRoute: Routes = [
    {
        path: 'record-25-herfinancieering-my-suffix',
        component: Record25HerfinancieeringMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-25-herfinancieering-my-suffix/:id/view',
        component: Record25HerfinancieeringMySuffixDetailComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-25-herfinancieering-my-suffix/new',
        component: Record25HerfinancieeringMySuffixUpdateComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-25-herfinancieering-my-suffix/:id/edit',
        component: Record25HerfinancieeringMySuffixUpdateComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record25HerfinancieeringPopupRoute: Routes = [
    {
        path: 'record-25-herfinancieering-my-suffix/:id/delete',
        component: Record25HerfinancieeringMySuffixDeletePopupComponent,
        resolve: {
            record25Herfinancieering: Record25HerfinancieeringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record25Herfinancieering.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
