import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record30InruilComponent,
    Record30InruilDetailComponent,
    Record30InruilUpdateComponent,
    Record30InruilDeletePopupComponent,
    Record30InruilDeleteDialogComponent,
    record30InruilRoute,
    record30InruilPopupRoute
} from './';

const ENTITY_STATES = [...record30InruilRoute, ...record30InruilPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record30InruilComponent,
        Record30InruilDetailComponent,
        Record30InruilUpdateComponent,
        Record30InruilDeleteDialogComponent,
        Record30InruilDeletePopupComponent
    ],
    entryComponents: [
        Record30InruilComponent,
        Record30InruilUpdateComponent,
        Record30InruilDeleteDialogComponent,
        Record30InruilDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord30InruilModule {}
