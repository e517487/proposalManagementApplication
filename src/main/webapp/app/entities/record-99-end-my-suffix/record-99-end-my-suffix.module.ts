import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record99EndMySuffixComponent,
    Record99EndMySuffixDetailComponent,
    Record99EndMySuffixUpdateComponent,
    Record99EndMySuffixDeletePopupComponent,
    Record99EndMySuffixDeleteDialogComponent,
    record99EndRoute,
    record99EndPopupRoute
} from './';

const ENTITY_STATES = [...record99EndRoute, ...record99EndPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record99EndMySuffixComponent,
        Record99EndMySuffixDetailComponent,
        Record99EndMySuffixUpdateComponent,
        Record99EndMySuffixDeleteDialogComponent,
        Record99EndMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record99EndMySuffixComponent,
        Record99EndMySuffixUpdateComponent,
        Record99EndMySuffixDeleteDialogComponent,
        Record99EndMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord99EndMySuffixModule {}
