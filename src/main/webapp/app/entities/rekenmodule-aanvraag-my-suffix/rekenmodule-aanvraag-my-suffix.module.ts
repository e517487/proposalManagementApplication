import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    RekenmoduleAanvraagMySuffixComponent,
    RekenmoduleAanvraagMySuffixDetailComponent,
    RekenmoduleAanvraagMySuffixUpdateComponent,
    RekenmoduleAanvraagMySuffixDeletePopupComponent,
    RekenmoduleAanvraagMySuffixDeleteDialogComponent,
    rekenmoduleAanvraagRoute,
    rekenmoduleAanvraagPopupRoute
} from './';

const ENTITY_STATES = [...rekenmoduleAanvraagRoute, ...rekenmoduleAanvraagPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        RekenmoduleAanvraagMySuffixComponent,
        RekenmoduleAanvraagMySuffixDetailComponent,
        RekenmoduleAanvraagMySuffixUpdateComponent,
        RekenmoduleAanvraagMySuffixDeleteDialogComponent,
        RekenmoduleAanvraagMySuffixDeletePopupComponent
    ],
    entryComponents: [
        RekenmoduleAanvraagMySuffixComponent,
        RekenmoduleAanvraagMySuffixUpdateComponent,
        RekenmoduleAanvraagMySuffixDeleteDialogComponent,
        RekenmoduleAanvraagMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRekenmoduleAanvraagMySuffixModule {}
