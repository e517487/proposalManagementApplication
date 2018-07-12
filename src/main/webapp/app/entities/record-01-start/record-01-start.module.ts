import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record01StartComponent,
    Record01StartDetailComponent,
    Record01StartUpdateComponent,
    Record01StartDeletePopupComponent,
    Record01StartDeleteDialogComponent,
    record01StartRoute,
    record01StartPopupRoute
} from './';

const ENTITY_STATES = [...record01StartRoute, ...record01StartPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record01StartComponent,
        Record01StartDetailComponent,
        Record01StartUpdateComponent,
        Record01StartDeleteDialogComponent,
        Record01StartDeletePopupComponent
    ],
    entryComponents: [
        Record01StartComponent,
        Record01StartUpdateComponent,
        Record01StartDeleteDialogComponent,
        Record01StartDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord01StartModule {}
