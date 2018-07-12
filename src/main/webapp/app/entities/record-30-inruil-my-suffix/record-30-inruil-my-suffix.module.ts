import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record30InruilMySuffixComponent,
    Record30InruilMySuffixDetailComponent,
    Record30InruilMySuffixUpdateComponent,
    Record30InruilMySuffixDeletePopupComponent,
    Record30InruilMySuffixDeleteDialogComponent,
    record30InruilRoute,
    record30InruilPopupRoute
} from './';

const ENTITY_STATES = [...record30InruilRoute, ...record30InruilPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record30InruilMySuffixComponent,
        Record30InruilMySuffixDetailComponent,
        Record30InruilMySuffixUpdateComponent,
        Record30InruilMySuffixDeleteDialogComponent,
        Record30InruilMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record30InruilMySuffixComponent,
        Record30InruilMySuffixUpdateComponent,
        Record30InruilMySuffixDeleteDialogComponent,
        Record30InruilMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord30InruilMySuffixModule {}
