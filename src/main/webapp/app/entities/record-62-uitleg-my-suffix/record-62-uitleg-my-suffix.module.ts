import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record62UitlegMySuffixComponent,
    Record62UitlegMySuffixDetailComponent,
    Record62UitlegMySuffixUpdateComponent,
    Record62UitlegMySuffixDeletePopupComponent,
    Record62UitlegMySuffixDeleteDialogComponent,
    record62UitlegRoute,
    record62UitlegPopupRoute
} from './';

const ENTITY_STATES = [...record62UitlegRoute, ...record62UitlegPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record62UitlegMySuffixComponent,
        Record62UitlegMySuffixDetailComponent,
        Record62UitlegMySuffixUpdateComponent,
        Record62UitlegMySuffixDeleteDialogComponent,
        Record62UitlegMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record62UitlegMySuffixComponent,
        Record62UitlegMySuffixUpdateComponent,
        Record62UitlegMySuffixDeleteDialogComponent,
        Record62UitlegMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord62UitlegMySuffixModule {}
