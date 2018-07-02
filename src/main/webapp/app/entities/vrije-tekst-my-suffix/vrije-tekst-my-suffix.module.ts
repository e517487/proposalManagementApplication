import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    VrijeTekstMySuffixComponent,
    VrijeTekstMySuffixDetailComponent,
    VrijeTekstMySuffixUpdateComponent,
    VrijeTekstMySuffixDeletePopupComponent,
    VrijeTekstMySuffixDeleteDialogComponent,
    vrijeTekstRoute,
    vrijeTekstPopupRoute
} from './';

const ENTITY_STATES = [...vrijeTekstRoute, ...vrijeTekstPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        VrijeTekstMySuffixComponent,
        VrijeTekstMySuffixDetailComponent,
        VrijeTekstMySuffixUpdateComponent,
        VrijeTekstMySuffixDeleteDialogComponent,
        VrijeTekstMySuffixDeletePopupComponent
    ],
    entryComponents: [
        VrijeTekstMySuffixComponent,
        VrijeTekstMySuffixUpdateComponent,
        VrijeTekstMySuffixDeleteDialogComponent,
        VrijeTekstMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationVrijeTekstMySuffixModule {}
