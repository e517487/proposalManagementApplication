import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    AanvraagberichtMySuffixComponent,
    AanvraagberichtMySuffixDetailComponent,
    AanvraagberichtMySuffixUpdateComponent,
    AanvraagberichtMySuffixDeletePopupComponent,
    AanvraagberichtMySuffixDeleteDialogComponent,
    aanvraagberichtRoute,
    aanvraagberichtPopupRoute
} from './';

const ENTITY_STATES = [...aanvraagberichtRoute, ...aanvraagberichtPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        AanvraagberichtMySuffixComponent,
        AanvraagberichtMySuffixDetailComponent,
        AanvraagberichtMySuffixUpdateComponent,
        AanvraagberichtMySuffixDeleteDialogComponent,
        AanvraagberichtMySuffixDeletePopupComponent
    ],
    entryComponents: [
        AanvraagberichtMySuffixComponent,
        AanvraagberichtMySuffixUpdateComponent,
        AanvraagberichtMySuffixDeleteDialogComponent,
        AanvraagberichtMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationAanvraagberichtMySuffixModule {}
