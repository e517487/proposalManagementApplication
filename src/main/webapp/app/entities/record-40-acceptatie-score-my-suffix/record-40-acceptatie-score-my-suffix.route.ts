import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';
import { Record40AcceptatieScoreMySuffixService } from './record-40-acceptatie-score-my-suffix.service';
import { Record40AcceptatieScoreMySuffixComponent } from './record-40-acceptatie-score-my-suffix.component';
import { Record40AcceptatieScoreMySuffixDetailComponent } from './record-40-acceptatie-score-my-suffix-detail.component';
import { Record40AcceptatieScoreMySuffixUpdateComponent } from './record-40-acceptatie-score-my-suffix-update.component';
import { Record40AcceptatieScoreMySuffixDeletePopupComponent } from './record-40-acceptatie-score-my-suffix-delete-dialog.component';
import { IRecord40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record40AcceptatieScoreMySuffixResolve implements Resolve<IRecord40AcceptatieScoreMySuffix> {
    constructor(private service: Record40AcceptatieScoreMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map((record40AcceptatieScore: HttpResponse<Record40AcceptatieScoreMySuffix>) => record40AcceptatieScore.body);
        }
        return Observable.of(new Record40AcceptatieScoreMySuffix());
    }
}

export const record40AcceptatieScoreRoute: Routes = [
    {
        path: 'record-40-acceptatie-score-my-suffix',
        component: Record40AcceptatieScoreMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-40-acceptatie-score-my-suffix/:id/view',
        component: Record40AcceptatieScoreMySuffixDetailComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-40-acceptatie-score-my-suffix/new',
        component: Record40AcceptatieScoreMySuffixUpdateComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-40-acceptatie-score-my-suffix/:id/edit',
        component: Record40AcceptatieScoreMySuffixUpdateComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record40AcceptatieScorePopupRoute: Routes = [
    {
        path: 'record-40-acceptatie-score-my-suffix/:id/delete',
        component: Record40AcceptatieScoreMySuffixDeletePopupComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
