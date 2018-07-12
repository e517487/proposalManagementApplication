import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';
import { Record40AcceptatieScoreService } from './record-40-acceptatie-score.service';
import { Record40AcceptatieScoreComponent } from './record-40-acceptatie-score.component';
import { Record40AcceptatieScoreDetailComponent } from './record-40-acceptatie-score-detail.component';
import { Record40AcceptatieScoreUpdateComponent } from './record-40-acceptatie-score-update.component';
import { Record40AcceptatieScoreDeletePopupComponent } from './record-40-acceptatie-score-delete-dialog.component';
import { IRecord40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';

@Injectable({ providedIn: 'root' })
export class Record40AcceptatieScoreResolve implements Resolve<IRecord40AcceptatieScore> {
    constructor(private service: Record40AcceptatieScoreService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service
                .find(id)
                .map((record40AcceptatieScore: HttpResponse<Record40AcceptatieScore>) => record40AcceptatieScore.body);
        }
        return Observable.of(new Record40AcceptatieScore());
    }
}

export const record40AcceptatieScoreRoute: Routes = [
    {
        path: 'record-40-acceptatie-score',
        component: Record40AcceptatieScoreComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-40-acceptatie-score/:id/view',
        component: Record40AcceptatieScoreDetailComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-40-acceptatie-score/new',
        component: Record40AcceptatieScoreUpdateComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-40-acceptatie-score/:id/edit',
        component: Record40AcceptatieScoreUpdateComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreResolve
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
        path: 'record-40-acceptatie-score/:id/delete',
        component: Record40AcceptatieScoreDeletePopupComponent,
        resolve: {
            record40AcceptatieScore: Record40AcceptatieScoreResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record40AcceptatieScore.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
