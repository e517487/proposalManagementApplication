import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    WerksituatieMySuffixComponent,
    WerksituatieMySuffixDetailComponent,
    WerksituatieMySuffixUpdateComponent,
    WerksituatieMySuffixDeletePopupComponent,
    WerksituatieMySuffixDeleteDialogComponent,
    werksituatieRoute,
    werksituatiePopupRoute
} from './';

const ENTITY_STATES = [...werksituatieRoute, ...werksituatiePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        WerksituatieMySuffixComponent,
        WerksituatieMySuffixDetailComponent,
        WerksituatieMySuffixUpdateComponent,
        WerksituatieMySuffixDeleteDialogComponent,
        WerksituatieMySuffixDeletePopupComponent
    ],
    entryComponents: [
        WerksituatieMySuffixComponent,
        WerksituatieMySuffixUpdateComponent,
        WerksituatieMySuffixDeleteDialogComponent,
        WerksituatieMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationWerksituatieMySuffixModule {}
