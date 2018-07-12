import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record55Scoring } from 'app/shared/model/record-55-scoring.model';
import { Record55ScoringService } from './record-55-scoring.service';
import { Record55ScoringComponent } from './record-55-scoring.component';
import { Record55ScoringDetailComponent } from './record-55-scoring-detail.component';
import { Record55ScoringUpdateComponent } from './record-55-scoring-update.component';
import { Record55ScoringDeletePopupComponent } from './record-55-scoring-delete-dialog.component';
import { IRecord55Scoring } from 'app/shared/model/record-55-scoring.model';

@Injectable({ providedIn: 'root' })
export class Record55ScoringResolve implements Resolve<IRecord55Scoring> {
    constructor(private service: Record55ScoringService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record55Scoring: HttpResponse<Record55Scoring>) => record55Scoring.body);
        }
        return Observable.of(new Record55Scoring());
    }
}

export const record55ScoringRoute: Routes = [
    {
        path: 'record-55-scoring',
        component: Record55ScoringComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-55-scoring/:id/view',
        component: Record55ScoringDetailComponent,
        resolve: {
            record55Scoring: Record55ScoringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-55-scoring/new',
        component: Record55ScoringUpdateComponent,
        resolve: {
            record55Scoring: Record55ScoringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-55-scoring/:id/edit',
        component: Record55ScoringUpdateComponent,
        resolve: {
            record55Scoring: Record55ScoringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const record55ScoringPopupRoute: Routes = [
    {
        path: 'record-55-scoring/:id/delete',
        component: Record55ScoringDeletePopupComponent,
        resolve: {
            record55Scoring: Record55ScoringResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
