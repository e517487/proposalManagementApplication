import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record40AcceptatieScoreComponent,
    Record40AcceptatieScoreDetailComponent,
    Record40AcceptatieScoreUpdateComponent,
    Record40AcceptatieScoreDeletePopupComponent,
    Record40AcceptatieScoreDeleteDialogComponent,
    record40AcceptatieScoreRoute,
    record40AcceptatieScorePopupRoute
} from './';

const ENTITY_STATES = [...record40AcceptatieScoreRoute, ...record40AcceptatieScorePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record40AcceptatieScoreComponent,
        Record40AcceptatieScoreDetailComponent,
        Record40AcceptatieScoreUpdateComponent,
        Record40AcceptatieScoreDeleteDialogComponent,
        Record40AcceptatieScoreDeletePopupComponent
    ],
    entryComponents: [
        Record40AcceptatieScoreComponent,
        Record40AcceptatieScoreUpdateComponent,
        Record40AcceptatieScoreDeleteDialogComponent,
        Record40AcceptatieScoreDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord40AcceptatieScoreModule {}
