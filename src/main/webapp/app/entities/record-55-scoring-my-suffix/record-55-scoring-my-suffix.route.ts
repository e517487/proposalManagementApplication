import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable } from 'rxjs';
import { Record55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';
import { Record55ScoringMySuffixService } from './record-55-scoring-my-suffix.service';
import { Record55ScoringMySuffixComponent } from './record-55-scoring-my-suffix.component';
import { Record55ScoringMySuffixDetailComponent } from './record-55-scoring-my-suffix-detail.component';
import { Record55ScoringMySuffixUpdateComponent } from './record-55-scoring-my-suffix-update.component';
import { Record55ScoringMySuffixDeletePopupComponent } from './record-55-scoring-my-suffix-delete-dialog.component';
import { IRecord55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';

@Injectable({ providedIn: 'root' })
export class Record55ScoringMySuffixResolve implements Resolve<IRecord55ScoringMySuffix> {
    constructor(private service: Record55ScoringMySuffixService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).map((record55Scoring: HttpResponse<Record55ScoringMySuffix>) => record55Scoring.body);
        }
        return Observable.of(new Record55ScoringMySuffix());
    }
}

export const record55ScoringRoute: Routes = [
    {
        path: 'record-55-scoring-my-suffix',
        component: Record55ScoringMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-55-scoring-my-suffix/:id/view',
        component: Record55ScoringMySuffixDetailComponent,
        resolve: {
            record55Scoring: Record55ScoringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-55-scoring-my-suffix/new',
        component: Record55ScoringMySuffixUpdateComponent,
        resolve: {
            record55Scoring: Record55ScoringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'record-55-scoring-my-suffix/:id/edit',
        component: Record55ScoringMySuffixUpdateComponent,
        resolve: {
            record55Scoring: Record55ScoringMySuffixResolve
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
        path: 'record-55-scoring-my-suffix/:id/delete',
        component: Record55ScoringMySuffixDeletePopupComponent,
        resolve: {
            record55Scoring: Record55ScoringMySuffixResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'proposalManagementApplicationApp.record55Scoring.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
