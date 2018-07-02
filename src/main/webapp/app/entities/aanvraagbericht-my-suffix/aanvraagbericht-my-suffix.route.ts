import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { AanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';
import { AanvraagberichtMySuffixService } from './aanvraagbericht-my-suffix.service';
import { AanvraagberichtMySuffixComponent } from './aanvraagbericht-my-suffix.component';
import { AanvraagberichtMySuffixDetailComponent } from './aanvraagbericht-my-suffix-detail.component';
import { AanvraagberichtMySuffixUpdateComponent } from './aanvraagbericht-my-suffix-update.component';
import { AanvraagberichtMySuffixDeletePopupComponent } from './aanvraagbericht-my-suffix-delete-dialog.component';
import { IAanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class AanvraagberichtMySuffixResolve implements Resolve<IAanvraagberichtMySuffix> {
    constructor(private service: AanvraagberichtMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((aanvraagbericht: HttpResponse<AanvraagberichtMySuffix>) => aanvraagbericht.body);
        }
        return Observable.of(new AanvraagberichtMySuffix());
    }
}

export const aanvraagberichtRoute: Routes = [
    {
        path: 'aanvraagbericht-my-suffix',
        component: AanvraagberichtMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.aanvraagbericht.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'aanvraagbericht-my-suffix/:id/view',
        component: AanvraagberichtMySuffixDetailComponent,
        resolve: {
            aanvraagbericht: AanvraagberichtMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.aanvraagbericht.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'aanvraagbericht-my-suffix/new',
        component: AanvraagberichtMySuffixUpdateComponent,
        resolve: {
            aanvraagbericht: AanvraagberichtMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.aanvraagbericht.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'aanvraagbericht-my-suffix/:id/edit',
        component: AanvraagberichtMySuffixUpdateComponent,
        resolve: {
            aanvraagbericht: AanvraagberichtMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.aanvraagbericht.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const aanvraagberichtPopupRoute: Routes = [
    {
        path: 'aanvraagbericht-my-suffix/:id/delete',
        component: AanvraagberichtMySuffixDeletePopupComponent,
        resolve: {
            aanvraagbericht: AanvraagberichtMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.aanvraagbericht.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
