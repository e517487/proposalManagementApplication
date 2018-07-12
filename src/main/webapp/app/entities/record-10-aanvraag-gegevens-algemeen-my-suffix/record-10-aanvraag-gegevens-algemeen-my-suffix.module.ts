import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record10AanvraagGegevensAlgemeenMySuffixComponent,
    Record10AanvraagGegevensAlgemeenMySuffixDetailComponent,
    Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent,
    Record10AanvraagGegevensAlgemeenMySuffixDeletePopupComponent,
    Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent,
    record10AanvraagGegevensAlgemeenRoute,
    record10AanvraagGegevensAlgemeenPopupRoute
} from './';

const ENTITY_STATES = [...record10AanvraagGegevensAlgemeenRoute, ...record10AanvraagGegevensAlgemeenPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record10AanvraagGegevensAlgemeenMySuffixComponent,
        Record10AanvraagGegevensAlgemeenMySuffixDetailComponent,
        Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent,
        Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent,
        Record10AanvraagGegevensAlgemeenMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record10AanvraagGegevensAlgemeenMySuffixComponent,
        Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent,
        Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent,
        Record10AanvraagGegevensAlgemeenMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord10AanvraagGegevensAlgemeenMySuffixModule {}
