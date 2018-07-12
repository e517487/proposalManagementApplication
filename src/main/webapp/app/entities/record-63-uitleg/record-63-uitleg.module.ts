import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record63UitlegComponent,
    Record63UitlegDetailComponent,
    Record63UitlegUpdateComponent,
    Record63UitlegDeletePopupComponent,
    Record63UitlegDeleteDialogComponent,
    record63UitlegRoute,
    record63UitlegPopupRoute
} from './';

const ENTITY_STATES = [...record63UitlegRoute, ...record63UitlegPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record63UitlegComponent,
        Record63UitlegDetailComponent,
        Record63UitlegUpdateComponent,
        Record63UitlegDeleteDialogComponent,
        Record63UitlegDeletePopupComponent
    ],
    entryComponents: [
        Record63UitlegComponent,
        Record63UitlegUpdateComponent,
        Record63UitlegDeleteDialogComponent,
        Record63UitlegDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord63UitlegModule {}
