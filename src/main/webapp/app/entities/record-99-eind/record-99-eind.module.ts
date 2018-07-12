import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record99EindComponent,
    Record99EindDetailComponent,
    Record99EindUpdateComponent,
    Record99EindDeletePopupComponent,
    Record99EindDeleteDialogComponent,
    record99EindRoute,
    record99EindPopupRoute
} from './';

const ENTITY_STATES = [...record99EindRoute, ...record99EindPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record99EindComponent,
        Record99EindDetailComponent,
        Record99EindUpdateComponent,
        Record99EindDeleteDialogComponent,
        Record99EindDeletePopupComponent
    ],
    entryComponents: [
        Record99EindComponent,
        Record99EindUpdateComponent,
        Record99EindDeleteDialogComponent,
        Record99EindDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord99EindModule {}
