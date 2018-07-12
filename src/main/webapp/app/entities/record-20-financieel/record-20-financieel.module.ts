import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record20FinancieelComponent,
    Record20FinancieelDetailComponent,
    Record20FinancieelUpdateComponent,
    Record20FinancieelDeletePopupComponent,
    Record20FinancieelDeleteDialogComponent,
    record20FinancieelRoute,
    record20FinancieelPopupRoute
} from './';

const ENTITY_STATES = [...record20FinancieelRoute, ...record20FinancieelPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record20FinancieelComponent,
        Record20FinancieelDetailComponent,
        Record20FinancieelUpdateComponent,
        Record20FinancieelDeleteDialogComponent,
        Record20FinancieelDeletePopupComponent
    ],
    entryComponents: [
        Record20FinancieelComponent,
        Record20FinancieelUpdateComponent,
        Record20FinancieelDeleteDialogComponent,
        Record20FinancieelDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord20FinancieelModule {}
