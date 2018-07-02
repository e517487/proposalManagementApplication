import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    TekstRegelMySuffixComponent,
    TekstRegelMySuffixDetailComponent,
    TekstRegelMySuffixUpdateComponent,
    TekstRegelMySuffixDeletePopupComponent,
    TekstRegelMySuffixDeleteDialogComponent,
    tekstRegelRoute,
    tekstRegelPopupRoute
} from './';

const ENTITY_STATES = [...tekstRegelRoute, ...tekstRegelPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TekstRegelMySuffixComponent,
        TekstRegelMySuffixDetailComponent,
        TekstRegelMySuffixUpdateComponent,
        TekstRegelMySuffixDeleteDialogComponent,
        TekstRegelMySuffixDeletePopupComponent
    ],
    entryComponents: [
        TekstRegelMySuffixComponent,
        TekstRegelMySuffixUpdateComponent,
        TekstRegelMySuffixDeleteDialogComponent,
        TekstRegelMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationTekstRegelMySuffixModule {}
