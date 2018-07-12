import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record35ObjectMySuffixComponent,
    Record35ObjectMySuffixDetailComponent,
    Record35ObjectMySuffixUpdateComponent,
    Record35ObjectMySuffixDeletePopupComponent,
    Record35ObjectMySuffixDeleteDialogComponent,
    record35ObjectRoute,
    record35ObjectPopupRoute
} from './';

const ENTITY_STATES = [...record35ObjectRoute, ...record35ObjectPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record35ObjectMySuffixComponent,
        Record35ObjectMySuffixDetailComponent,
        Record35ObjectMySuffixUpdateComponent,
        Record35ObjectMySuffixDeleteDialogComponent,
        Record35ObjectMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record35ObjectMySuffixComponent,
        Record35ObjectMySuffixUpdateComponent,
        Record35ObjectMySuffixDeleteDialogComponent,
        Record35ObjectMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord35ObjectMySuffixModule {}
