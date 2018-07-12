import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record45RelatieMySuffixComponent,
    Record45RelatieMySuffixDetailComponent,
    Record45RelatieMySuffixUpdateComponent,
    Record45RelatieMySuffixDeletePopupComponent,
    Record45RelatieMySuffixDeleteDialogComponent,
    record45RelatieRoute,
    record45RelatiePopupRoute
} from './';

const ENTITY_STATES = [...record45RelatieRoute, ...record45RelatiePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record45RelatieMySuffixComponent,
        Record45RelatieMySuffixDetailComponent,
        Record45RelatieMySuffixUpdateComponent,
        Record45RelatieMySuffixDeleteDialogComponent,
        Record45RelatieMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record45RelatieMySuffixComponent,
        Record45RelatieMySuffixUpdateComponent,
        Record45RelatieMySuffixDeleteDialogComponent,
        Record45RelatieMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord45RelatieMySuffixModule {}
