import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    HeaderMySuffixComponent,
    HeaderMySuffixDetailComponent,
    HeaderMySuffixUpdateComponent,
    HeaderMySuffixDeletePopupComponent,
    HeaderMySuffixDeleteDialogComponent,
    headerRoute,
    headerPopupRoute
} from './';

const ENTITY_STATES = [...headerRoute, ...headerPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        HeaderMySuffixComponent,
        HeaderMySuffixDetailComponent,
        HeaderMySuffixUpdateComponent,
        HeaderMySuffixDeleteDialogComponent,
        HeaderMySuffixDeletePopupComponent
    ],
    entryComponents: [
        HeaderMySuffixComponent,
        HeaderMySuffixUpdateComponent,
        HeaderMySuffixDeleteDialogComponent,
        HeaderMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationHeaderMySuffixModule {}
