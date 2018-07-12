import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record11AanvraagGegevensOpmerkingenMySuffixComponent,
    Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent,
    Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent,
    Record11AanvraagGegevensOpmerkingenMySuffixDeletePopupComponent,
    Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent,
    record11AanvraagGegevensOpmerkingenRoute,
    record11AanvraagGegevensOpmerkingenPopupRoute
} from './';

const ENTITY_STATES = [...record11AanvraagGegevensOpmerkingenRoute, ...record11AanvraagGegevensOpmerkingenPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record11AanvraagGegevensOpmerkingenMySuffixComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record11AanvraagGegevensOpmerkingenMySuffixComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent,
        Record11AanvraagGegevensOpmerkingenMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord11AanvraagGegevensOpmerkingenMySuffixModule {}
