import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record20FinancieelMySuffixComponent,
    Record20FinancieelMySuffixDetailComponent,
    Record20FinancieelMySuffixUpdateComponent,
    Record20FinancieelMySuffixDeletePopupComponent,
    Record20FinancieelMySuffixDeleteDialogComponent,
    record20FinancieelRoute,
    record20FinancieelPopupRoute
} from './';

const ENTITY_STATES = [...record20FinancieelRoute, ...record20FinancieelPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record20FinancieelMySuffixComponent,
        Record20FinancieelMySuffixDetailComponent,
        Record20FinancieelMySuffixUpdateComponent,
        Record20FinancieelMySuffixDeleteDialogComponent,
        Record20FinancieelMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record20FinancieelMySuffixComponent,
        Record20FinancieelMySuffixUpdateComponent,
        Record20FinancieelMySuffixDeleteDialogComponent,
        Record20FinancieelMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord20FinancieelMySuffixModule {}
