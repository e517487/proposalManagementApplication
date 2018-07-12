import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record50BedrijfComponent,
    Record50BedrijfDetailComponent,
    Record50BedrijfUpdateComponent,
    Record50BedrijfDeletePopupComponent,
    Record50BedrijfDeleteDialogComponent,
    record50BedrijfRoute,
    record50BedrijfPopupRoute
} from './';

const ENTITY_STATES = [...record50BedrijfRoute, ...record50BedrijfPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record50BedrijfComponent,
        Record50BedrijfDetailComponent,
        Record50BedrijfUpdateComponent,
        Record50BedrijfDeleteDialogComponent,
        Record50BedrijfDeletePopupComponent
    ],
    entryComponents: [
        Record50BedrijfComponent,
        Record50BedrijfUpdateComponent,
        Record50BedrijfDeleteDialogComponent,
        Record50BedrijfDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord50BedrijfModule {}
