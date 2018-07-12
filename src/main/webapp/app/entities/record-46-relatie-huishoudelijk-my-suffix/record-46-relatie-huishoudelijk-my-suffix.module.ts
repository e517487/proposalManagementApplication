import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record46RelatieHuishoudelijkMySuffixComponent,
    Record46RelatieHuishoudelijkMySuffixDetailComponent,
    Record46RelatieHuishoudelijkMySuffixUpdateComponent,
    Record46RelatieHuishoudelijkMySuffixDeletePopupComponent,
    Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent,
    record46RelatieHuishoudelijkRoute,
    record46RelatieHuishoudelijkPopupRoute
} from './';

const ENTITY_STATES = [...record46RelatieHuishoudelijkRoute, ...record46RelatieHuishoudelijkPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record46RelatieHuishoudelijkMySuffixComponent,
        Record46RelatieHuishoudelijkMySuffixDetailComponent,
        Record46RelatieHuishoudelijkMySuffixUpdateComponent,
        Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent,
        Record46RelatieHuishoudelijkMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record46RelatieHuishoudelijkMySuffixComponent,
        Record46RelatieHuishoudelijkMySuffixUpdateComponent,
        Record46RelatieHuishoudelijkMySuffixDeleteDialogComponent,
        Record46RelatieHuishoudelijkMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord46RelatieHuishoudelijkMySuffixModule {}
