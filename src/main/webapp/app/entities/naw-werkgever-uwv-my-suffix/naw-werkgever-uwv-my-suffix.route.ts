import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { NawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';
import { NawWerkgeverUWVMySuffixService } from './naw-werkgever-uwv-my-suffix.service';
import { NawWerkgeverUWVMySuffixComponent } from './naw-werkgever-uwv-my-suffix.component';
import { NawWerkgeverUWVMySuffixDetailComponent } from './naw-werkgever-uwv-my-suffix-detail.component';
import { NawWerkgeverUWVMySuffixUpdateComponent } from './naw-werkgever-uwv-my-suffix-update.component';
import { NawWerkgeverUWVMySuffixDeletePopupComponent } from './naw-werkgever-uwv-my-suffix-delete-dialog.component';
import { INawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class NawWerkgeverUWVMySuffixResolve implements Resolve<INawWerkgeverUWVMySuffix> {
    constructor(private service: NawWerkgeverUWVMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((nawWerkgeverUWV: HttpResponse<NawWerkgeverUWVMySuffix>) => nawWerkgeverUWV.body);
        }
        return Observable.of(new NawWerkgeverUWVMySuffix());
    }
}

export const nawWerkgeverUWVRoute: Routes = [
    {
        path: 'naw-werkgever-uwv-my-suffix',
        component: NawWerkgeverUWVMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.nawWerkgeverUWV.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'naw-werkgever-uwv-my-suffix/:id/view',
        component: NawWerkgeverUWVMySuffixDetailComponent,
        resolve: {
            nawWerkgeverUWV: NawWerkgeverUWVMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.nawWerkgeverUWV.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'naw-werkgever-uwv-my-suffix/new',
        component: NawWerkgeverUWVMySuffixUpdateComponent,
        resolve: {
            nawWerkgeverUWV: NawWerkgeverUWVMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.nawWerkgeverUWV.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'naw-werkgever-uwv-my-suffix/:id/edit',
        component: NawWerkgeverUWVMySuffixUpdateComponent,
        resolve: {
            nawWerkgeverUWV: NawWerkgeverUWVMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.nawWerkgeverUWV.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const nawWerkgeverUWVPopupRoute: Routes = [
    {
        path: 'naw-werkgever-uwv-my-suffix/:id/delete',
        component: NawWerkgeverUWVMySuffixDeletePopupComponent,
        resolve: {
            nawWerkgeverUWV: NawWerkgeverUWVMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.nawWerkgeverUWV.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
