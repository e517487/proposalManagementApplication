import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record40AcceptatieScoreMySuffixComponent,
    Record40AcceptatieScoreMySuffixDetailComponent,
    Record40AcceptatieScoreMySuffixUpdateComponent,
    Record40AcceptatieScoreMySuffixDeletePopupComponent,
    Record40AcceptatieScoreMySuffixDeleteDialogComponent,
    record40AcceptatieScoreRoute,
    record40AcceptatieScorePopupRoute
} from './';

const ENTITY_STATES = [...record40AcceptatieScoreRoute, ...record40AcceptatieScorePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record40AcceptatieScoreMySuffixComponent,
        Record40AcceptatieScoreMySuffixDetailComponent,
        Record40AcceptatieScoreMySuffixUpdateComponent,
        Record40AcceptatieScoreMySuffixDeleteDialogComponent,
        Record40AcceptatieScoreMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record40AcceptatieScoreMySuffixComponent,
        Record40AcceptatieScoreMySuffixUpdateComponent,
        Record40AcceptatieScoreMySuffixDeleteDialogComponent,
        Record40AcceptatieScoreMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord40AcceptatieScoreMySuffixModule {}
