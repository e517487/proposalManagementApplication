import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record55ScoringMySuffixComponent,
    Record55ScoringMySuffixDetailComponent,
    Record55ScoringMySuffixUpdateComponent,
    Record55ScoringMySuffixDeletePopupComponent,
    Record55ScoringMySuffixDeleteDialogComponent,
    record55ScoringRoute,
    record55ScoringPopupRoute
} from './';

const ENTITY_STATES = [...record55ScoringRoute, ...record55ScoringPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record55ScoringMySuffixComponent,
        Record55ScoringMySuffixDetailComponent,
        Record55ScoringMySuffixUpdateComponent,
        Record55ScoringMySuffixDeleteDialogComponent,
        Record55ScoringMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record55ScoringMySuffixComponent,
        Record55ScoringMySuffixUpdateComponent,
        Record55ScoringMySuffixDeleteDialogComponent,
        Record55ScoringMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord55ScoringMySuffixModule {}
