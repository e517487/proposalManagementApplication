import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    RequestMySuffixComponent,
    RequestMySuffixDetailComponent,
    RequestMySuffixUpdateComponent,
    RequestMySuffixDeletePopupComponent,
    RequestMySuffixDeleteDialogComponent,
    requestRoute,
    requestPopupRoute
} from './';

const ENTITY_STATES = [...requestRoute, ...requestPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        RequestMySuffixComponent,
        RequestMySuffixDetailComponent,
        RequestMySuffixUpdateComponent,
        RequestMySuffixDeleteDialogComponent,
        RequestMySuffixDeletePopupComponent
    ],
    entryComponents: [
        RequestMySuffixComponent,
        RequestMySuffixUpdateComponent,
        RequestMySuffixDeleteDialogComponent,
        RequestMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRequestMySuffixModule {}
