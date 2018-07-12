import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record61UitlegComponent,
    Record61UitlegDetailComponent,
    Record61UitlegUpdateComponent,
    Record61UitlegDeletePopupComponent,
    Record61UitlegDeleteDialogComponent,
    record61UitlegRoute,
    record61UitlegPopupRoute
} from './';

const ENTITY_STATES = [...record61UitlegRoute, ...record61UitlegPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record61UitlegComponent,
        Record61UitlegDetailComponent,
        Record61UitlegUpdateComponent,
        Record61UitlegDeleteDialogComponent,
        Record61UitlegDeletePopupComponent
    ],
    entryComponents: [
        Record61UitlegComponent,
        Record61UitlegUpdateComponent,
        Record61UitlegDeleteDialogComponent,
        Record61UitlegDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord61UitlegModule {}
