import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record63UitlegMySuffixComponent,
    Record63UitlegMySuffixDetailComponent,
    Record63UitlegMySuffixUpdateComponent,
    Record63UitlegMySuffixDeletePopupComponent,
    Record63UitlegMySuffixDeleteDialogComponent,
    record63UitlegRoute,
    record63UitlegPopupRoute
} from './';

const ENTITY_STATES = [...record63UitlegRoute, ...record63UitlegPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record63UitlegMySuffixComponent,
        Record63UitlegMySuffixDetailComponent,
        Record63UitlegMySuffixUpdateComponent,
        Record63UitlegMySuffixDeleteDialogComponent,
        Record63UitlegMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record63UitlegMySuffixComponent,
        Record63UitlegMySuffixUpdateComponent,
        Record63UitlegMySuffixDeleteDialogComponent,
        Record63UitlegMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord63UitlegMySuffixModule {}
