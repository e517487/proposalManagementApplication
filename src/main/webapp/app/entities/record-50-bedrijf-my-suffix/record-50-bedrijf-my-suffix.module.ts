import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record50BedrijfMySuffixComponent,
    Record50BedrijfMySuffixDetailComponent,
    Record50BedrijfMySuffixUpdateComponent,
    Record50BedrijfMySuffixDeletePopupComponent,
    Record50BedrijfMySuffixDeleteDialogComponent,
    record50BedrijfRoute,
    record50BedrijfPopupRoute
} from './';

const ENTITY_STATES = [...record50BedrijfRoute, ...record50BedrijfPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record50BedrijfMySuffixComponent,
        Record50BedrijfMySuffixDetailComponent,
        Record50BedrijfMySuffixUpdateComponent,
        Record50BedrijfMySuffixDeleteDialogComponent,
        Record50BedrijfMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record50BedrijfMySuffixComponent,
        Record50BedrijfMySuffixUpdateComponent,
        Record50BedrijfMySuffixDeleteDialogComponent,
        Record50BedrijfMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord50BedrijfMySuffixModule {}
