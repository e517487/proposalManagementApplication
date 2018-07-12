import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record99EindMySuffixComponent,
    Record99EindMySuffixDetailComponent,
    Record99EindMySuffixUpdateComponent,
    Record99EindMySuffixDeletePopupComponent,
    Record99EindMySuffixDeleteDialogComponent,
    record99EindRoute,
    record99EindPopupRoute
} from './';

const ENTITY_STATES = [...record99EindRoute, ...record99EindPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record99EindMySuffixComponent,
        Record99EindMySuffixDetailComponent,
        Record99EindMySuffixUpdateComponent,
        Record99EindMySuffixDeleteDialogComponent,
        Record99EindMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record99EindMySuffixComponent,
        Record99EindMySuffixUpdateComponent,
        Record99EindMySuffixDeleteDialogComponent,
        Record99EindMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord99EindMySuffixModule {}
