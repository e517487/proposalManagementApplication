import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record61UitlegMySuffixComponent,
    Record61UitlegMySuffixDetailComponent,
    Record61UitlegMySuffixUpdateComponent,
    Record61UitlegMySuffixDeletePopupComponent,
    Record61UitlegMySuffixDeleteDialogComponent,
    record61UitlegRoute,
    record61UitlegPopupRoute
} from './';

const ENTITY_STATES = [...record61UitlegRoute, ...record61UitlegPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record61UitlegMySuffixComponent,
        Record61UitlegMySuffixDetailComponent,
        Record61UitlegMySuffixUpdateComponent,
        Record61UitlegMySuffixDeleteDialogComponent,
        Record61UitlegMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record61UitlegMySuffixComponent,
        Record61UitlegMySuffixUpdateComponent,
        Record61UitlegMySuffixDeleteDialogComponent,
        Record61UitlegMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord61UitlegMySuffixModule {}
