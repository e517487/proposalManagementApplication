import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    NawWerkgeverUWVMySuffixComponent,
    NawWerkgeverUWVMySuffixDetailComponent,
    NawWerkgeverUWVMySuffixUpdateComponent,
    NawWerkgeverUWVMySuffixDeletePopupComponent,
    NawWerkgeverUWVMySuffixDeleteDialogComponent,
    nawWerkgeverUWVRoute,
    nawWerkgeverUWVPopupRoute
} from './';

const ENTITY_STATES = [...nawWerkgeverUWVRoute, ...nawWerkgeverUWVPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        NawWerkgeverUWVMySuffixComponent,
        NawWerkgeverUWVMySuffixDetailComponent,
        NawWerkgeverUWVMySuffixUpdateComponent,
        NawWerkgeverUWVMySuffixDeleteDialogComponent,
        NawWerkgeverUWVMySuffixDeletePopupComponent
    ],
    entryComponents: [
        NawWerkgeverUWVMySuffixComponent,
        NawWerkgeverUWVMySuffixUpdateComponent,
        NawWerkgeverUWVMySuffixDeleteDialogComponent,
        NawWerkgeverUWVMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationNawWerkgeverUWVMySuffixModule {}
