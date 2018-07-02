import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    AdresMySuffixComponent,
    AdresMySuffixDetailComponent,
    AdresMySuffixUpdateComponent,
    AdresMySuffixDeletePopupComponent,
    AdresMySuffixDeleteDialogComponent,
    adresRoute,
    adresPopupRoute
} from './';

const ENTITY_STATES = [...adresRoute, ...adresPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AdresMySuffixComponent,
        AdresMySuffixDetailComponent,
        AdresMySuffixUpdateComponent,
        AdresMySuffixDeleteDialogComponent,
        AdresMySuffixDeletePopupComponent
    ],
    entryComponents: [
        AdresMySuffixComponent,
        AdresMySuffixUpdateComponent,
        AdresMySuffixDeleteDialogComponent,
        AdresMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationAdresMySuffixModule {}
