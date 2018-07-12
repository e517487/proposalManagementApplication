import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record45RelatieComponent,
    Record45RelatieDetailComponent,
    Record45RelatieUpdateComponent,
    Record45RelatieDeletePopupComponent,
    Record45RelatieDeleteDialogComponent,
    record45RelatieRoute,
    record45RelatiePopupRoute
} from './';

const ENTITY_STATES = [...record45RelatieRoute, ...record45RelatiePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record45RelatieComponent,
        Record45RelatieDetailComponent,
        Record45RelatieUpdateComponent,
        Record45RelatieDeleteDialogComponent,
        Record45RelatieDeletePopupComponent
    ],
    entryComponents: [
        Record45RelatieComponent,
        Record45RelatieUpdateComponent,
        Record45RelatieDeleteDialogComponent,
        Record45RelatieDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord45RelatieModule {}
