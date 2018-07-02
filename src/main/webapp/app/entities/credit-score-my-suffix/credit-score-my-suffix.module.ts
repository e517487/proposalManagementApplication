import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    CreditScoreMySuffixComponent,
    CreditScoreMySuffixDetailComponent,
    CreditScoreMySuffixUpdateComponent,
    CreditScoreMySuffixDeletePopupComponent,
    CreditScoreMySuffixDeleteDialogComponent,
    creditScoreRoute,
    creditScorePopupRoute
} from './';

const ENTITY_STATES = [...creditScoreRoute, ...creditScorePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        CreditScoreMySuffixComponent,
        CreditScoreMySuffixDetailComponent,
        CreditScoreMySuffixUpdateComponent,
        CreditScoreMySuffixDeleteDialogComponent,
        CreditScoreMySuffixDeletePopupComponent
    ],
    entryComponents: [
        CreditScoreMySuffixComponent,
        CreditScoreMySuffixUpdateComponent,
        CreditScoreMySuffixDeleteDialogComponent,
        CreditScoreMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationCreditScoreMySuffixModule {}
