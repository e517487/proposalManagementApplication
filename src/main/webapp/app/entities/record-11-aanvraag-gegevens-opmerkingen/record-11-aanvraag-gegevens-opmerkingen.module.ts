import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record11AanvraagGegevensOpmerkingenComponent,
    Record11AanvraagGegevensOpmerkingenDetailComponent,
    Record11AanvraagGegevensOpmerkingenUpdateComponent,
    Record11AanvraagGegevensOpmerkingenDeletePopupComponent,
    Record11AanvraagGegevensOpmerkingenDeleteDialogComponent,
    record11AanvraagGegevensOpmerkingenRoute,
    record11AanvraagGegevensOpmerkingenPopupRoute
} from './';

const ENTITY_STATES = [...record11AanvraagGegevensOpmerkingenRoute, ...record11AanvraagGegevensOpmerkingenPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record11AanvraagGegevensOpmerkingenComponent,
        Record11AanvraagGegevensOpmerkingenDetailComponent,
        Record11AanvraagGegevensOpmerkingenUpdateComponent,
        Record11AanvraagGegevensOpmerkingenDeleteDialogComponent,
        Record11AanvraagGegevensOpmerkingenDeletePopupComponent
    ],
    entryComponents: [
        Record11AanvraagGegevensOpmerkingenComponent,
        Record11AanvraagGegevensOpmerkingenUpdateComponent,
        Record11AanvraagGegevensOpmerkingenDeleteDialogComponent,
        Record11AanvraagGegevensOpmerkingenDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord11AanvraagGegevensOpmerkingenModule {}
