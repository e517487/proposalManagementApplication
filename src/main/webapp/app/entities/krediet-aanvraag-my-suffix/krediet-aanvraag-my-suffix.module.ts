import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    KredietAanvraagMySuffixComponent,
    KredietAanvraagMySuffixDetailComponent,
    KredietAanvraagMySuffixUpdateComponent,
    KredietAanvraagMySuffixDeletePopupComponent,
    KredietAanvraagMySuffixDeleteDialogComponent,
    kredietAanvraagRoute,
    kredietAanvraagPopupRoute
} from './';

const ENTITY_STATES = [...kredietAanvraagRoute, ...kredietAanvraagPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        KredietAanvraagMySuffixComponent,
        KredietAanvraagMySuffixDetailComponent,
        KredietAanvraagMySuffixUpdateComponent,
        KredietAanvraagMySuffixDeleteDialogComponent,
        KredietAanvraagMySuffixDeletePopupComponent
    ],
    entryComponents: [
        KredietAanvraagMySuffixComponent,
        KredietAanvraagMySuffixUpdateComponent,
        KredietAanvraagMySuffixDeleteDialogComponent,
        KredietAanvraagMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationKredietAanvraagMySuffixModule {}
