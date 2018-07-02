import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    FinancieleSituatieMySuffixComponent,
    FinancieleSituatieMySuffixDetailComponent,
    FinancieleSituatieMySuffixUpdateComponent,
    FinancieleSituatieMySuffixDeletePopupComponent,
    FinancieleSituatieMySuffixDeleteDialogComponent,
    financieleSituatieRoute,
    financieleSituatiePopupRoute
} from './';

const ENTITY_STATES = [...financieleSituatieRoute, ...financieleSituatiePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        FinancieleSituatieMySuffixComponent,
        FinancieleSituatieMySuffixDetailComponent,
        FinancieleSituatieMySuffixUpdateComponent,
        FinancieleSituatieMySuffixDeleteDialogComponent,
        FinancieleSituatieMySuffixDeletePopupComponent
    ],
    entryComponents: [
        FinancieleSituatieMySuffixComponent,
        FinancieleSituatieMySuffixUpdateComponent,
        FinancieleSituatieMySuffixDeleteDialogComponent,
        FinancieleSituatieMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationFinancieleSituatieMySuffixModule {}
