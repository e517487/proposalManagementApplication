import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record35ObjectComponent,
    Record35ObjectDetailComponent,
    Record35ObjectUpdateComponent,
    Record35ObjectDeletePopupComponent,
    Record35ObjectDeleteDialogComponent,
    record35ObjectRoute,
    record35ObjectPopupRoute
} from './';

const ENTITY_STATES = [...record35ObjectRoute, ...record35ObjectPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record35ObjectComponent,
        Record35ObjectDetailComponent,
        Record35ObjectUpdateComponent,
        Record35ObjectDeleteDialogComponent,
        Record35ObjectDeletePopupComponent
    ],
    entryComponents: [
        Record35ObjectComponent,
        Record35ObjectUpdateComponent,
        Record35ObjectDeleteDialogComponent,
        Record35ObjectDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord35ObjectModule {}
