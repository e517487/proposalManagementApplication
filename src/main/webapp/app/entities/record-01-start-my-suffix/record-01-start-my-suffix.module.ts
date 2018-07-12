import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record01StartMySuffixComponent,
    Record01StartMySuffixDetailComponent,
    Record01StartMySuffixUpdateComponent,
    Record01StartMySuffixDeletePopupComponent,
    Record01StartMySuffixDeleteDialogComponent,
    record01StartRoute,
    record01StartPopupRoute
} from './';

const ENTITY_STATES = [...record01StartRoute, ...record01StartPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record01StartMySuffixComponent,
        Record01StartMySuffixDetailComponent,
        Record01StartMySuffixUpdateComponent,
        Record01StartMySuffixDeleteDialogComponent,
        Record01StartMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record01StartMySuffixComponent,
        Record01StartMySuffixUpdateComponent,
        Record01StartMySuffixDeleteDialogComponent,
        Record01StartMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord01StartMySuffixModule {}
