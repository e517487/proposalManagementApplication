import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record55ScoringComponent,
    Record55ScoringDetailComponent,
    Record55ScoringUpdateComponent,
    Record55ScoringDeletePopupComponent,
    Record55ScoringDeleteDialogComponent,
    record55ScoringRoute,
    record55ScoringPopupRoute
} from './';

const ENTITY_STATES = [...record55ScoringRoute, ...record55ScoringPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record55ScoringComponent,
        Record55ScoringDetailComponent,
        Record55ScoringUpdateComponent,
        Record55ScoringDeleteDialogComponent,
        Record55ScoringDeletePopupComponent
    ],
    entryComponents: [
        Record55ScoringComponent,
        Record55ScoringUpdateComponent,
        Record55ScoringDeleteDialogComponent,
        Record55ScoringDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord55ScoringModule {}
