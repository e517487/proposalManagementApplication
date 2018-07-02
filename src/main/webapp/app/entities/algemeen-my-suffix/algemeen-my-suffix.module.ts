import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    AlgemeenMySuffixComponent,
    AlgemeenMySuffixDetailComponent,
    AlgemeenMySuffixUpdateComponent,
    AlgemeenMySuffixDeletePopupComponent,
    AlgemeenMySuffixDeleteDialogComponent,
    algemeenRoute,
    algemeenPopupRoute
} from './';

const ENTITY_STATES = [...algemeenRoute, ...algemeenPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AlgemeenMySuffixComponent,
        AlgemeenMySuffixDetailComponent,
        AlgemeenMySuffixUpdateComponent,
        AlgemeenMySuffixDeleteDialogComponent,
        AlgemeenMySuffixDeletePopupComponent
    ],
    entryComponents: [
        AlgemeenMySuffixComponent,
        AlgemeenMySuffixUpdateComponent,
        AlgemeenMySuffixDeleteDialogComponent,
        AlgemeenMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationAlgemeenMySuffixModule {}
