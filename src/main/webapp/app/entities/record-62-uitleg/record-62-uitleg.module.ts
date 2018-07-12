import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record62UitlegComponent,
    Record62UitlegDetailComponent,
    Record62UitlegUpdateComponent,
    Record62UitlegDeletePopupComponent,
    Record62UitlegDeleteDialogComponent,
    record62UitlegRoute,
    record62UitlegPopupRoute
} from './';

const ENTITY_STATES = [...record62UitlegRoute, ...record62UitlegPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record62UitlegComponent,
        Record62UitlegDetailComponent,
        Record62UitlegUpdateComponent,
        Record62UitlegDeleteDialogComponent,
        Record62UitlegDeletePopupComponent
    ],
    entryComponents: [
        Record62UitlegComponent,
        Record62UitlegUpdateComponent,
        Record62UitlegDeleteDialogComponent,
        Record62UitlegDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord62UitlegModule {}
