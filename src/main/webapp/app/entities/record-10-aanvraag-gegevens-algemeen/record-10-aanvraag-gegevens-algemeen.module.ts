import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record10AanvraagGegevensAlgemeenComponent,
    Record10AanvraagGegevensAlgemeenDetailComponent,
    Record10AanvraagGegevensAlgemeenUpdateComponent,
    Record10AanvraagGegevensAlgemeenDeletePopupComponent,
    Record10AanvraagGegevensAlgemeenDeleteDialogComponent,
    record10AanvraagGegevensAlgemeenRoute,
    record10AanvraagGegevensAlgemeenPopupRoute
} from './';

const ENTITY_STATES = [...record10AanvraagGegevensAlgemeenRoute, ...record10AanvraagGegevensAlgemeenPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record10AanvraagGegevensAlgemeenComponent,
        Record10AanvraagGegevensAlgemeenDetailComponent,
        Record10AanvraagGegevensAlgemeenUpdateComponent,
        Record10AanvraagGegevensAlgemeenDeleteDialogComponent,
        Record10AanvraagGegevensAlgemeenDeletePopupComponent
    ],
    entryComponents: [
        Record10AanvraagGegevensAlgemeenComponent,
        Record10AanvraagGegevensAlgemeenUpdateComponent,
        Record10AanvraagGegevensAlgemeenDeleteDialogComponent,
        Record10AanvraagGegevensAlgemeenDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord10AanvraagGegevensAlgemeenModule {}
