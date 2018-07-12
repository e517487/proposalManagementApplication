import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record46RelatieHuishoudelijkComponent,
    Record46RelatieHuishoudelijkDetailComponent,
    Record46RelatieHuishoudelijkUpdateComponent,
    Record46RelatieHuishoudelijkDeletePopupComponent,
    Record46RelatieHuishoudelijkDeleteDialogComponent,
    record46RelatieHuishoudelijkRoute,
    record46RelatieHuishoudelijkPopupRoute
} from './';

const ENTITY_STATES = [...record46RelatieHuishoudelijkRoute, ...record46RelatieHuishoudelijkPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record46RelatieHuishoudelijkComponent,
        Record46RelatieHuishoudelijkDetailComponent,
        Record46RelatieHuishoudelijkUpdateComponent,
        Record46RelatieHuishoudelijkDeleteDialogComponent,
        Record46RelatieHuishoudelijkDeletePopupComponent
    ],
    entryComponents: [
        Record46RelatieHuishoudelijkComponent,
        Record46RelatieHuishoudelijkUpdateComponent,
        Record46RelatieHuishoudelijkDeleteDialogComponent,
        Record46RelatieHuishoudelijkDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord46RelatieHuishoudelijkModule {}
