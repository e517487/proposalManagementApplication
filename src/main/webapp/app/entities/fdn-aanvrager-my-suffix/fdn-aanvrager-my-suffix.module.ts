import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    FdnAanvragerMySuffixComponent,
    FdnAanvragerMySuffixDetailComponent,
    FdnAanvragerMySuffixUpdateComponent,
    FdnAanvragerMySuffixDeletePopupComponent,
    FdnAanvragerMySuffixDeleteDialogComponent,
    fdnAanvragerRoute,
    fdnAanvragerPopupRoute
} from './';

const ENTITY_STATES = [...fdnAanvragerRoute, ...fdnAanvragerPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        FdnAanvragerMySuffixComponent,
        FdnAanvragerMySuffixDetailComponent,
        FdnAanvragerMySuffixUpdateComponent,
        FdnAanvragerMySuffixDeleteDialogComponent,
        FdnAanvragerMySuffixDeletePopupComponent
    ],
    entryComponents: [
        FdnAanvragerMySuffixComponent,
        FdnAanvragerMySuffixUpdateComponent,
        FdnAanvragerMySuffixDeleteDialogComponent,
        FdnAanvragerMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationFdnAanvragerMySuffixModule {}
