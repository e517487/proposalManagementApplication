import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    LegitimatiebewijsMySuffixComponent,
    LegitimatiebewijsMySuffixDetailComponent,
    LegitimatiebewijsMySuffixUpdateComponent,
    LegitimatiebewijsMySuffixDeletePopupComponent,
    LegitimatiebewijsMySuffixDeleteDialogComponent,
    legitimatiebewijsRoute,
    legitimatiebewijsPopupRoute
} from './';

const ENTITY_STATES = [...legitimatiebewijsRoute, ...legitimatiebewijsPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        LegitimatiebewijsMySuffixComponent,
        LegitimatiebewijsMySuffixDetailComponent,
        LegitimatiebewijsMySuffixUpdateComponent,
        LegitimatiebewijsMySuffixDeleteDialogComponent,
        LegitimatiebewijsMySuffixDeletePopupComponent
    ],
    entryComponents: [
        LegitimatiebewijsMySuffixComponent,
        LegitimatiebewijsMySuffixUpdateComponent,
        LegitimatiebewijsMySuffixDeleteDialogComponent,
        LegitimatiebewijsMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationLegitimatiebewijsMySuffixModule {}
