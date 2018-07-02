import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    GezinssituatieMySuffixComponent,
    GezinssituatieMySuffixDetailComponent,
    GezinssituatieMySuffixUpdateComponent,
    GezinssituatieMySuffixDeletePopupComponent,
    GezinssituatieMySuffixDeleteDialogComponent,
    gezinssituatieRoute,
    gezinssituatiePopupRoute
} from './';

const ENTITY_STATES = [...gezinssituatieRoute, ...gezinssituatiePopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        GezinssituatieMySuffixComponent,
        GezinssituatieMySuffixDetailComponent,
        GezinssituatieMySuffixUpdateComponent,
        GezinssituatieMySuffixDeleteDialogComponent,
        GezinssituatieMySuffixDeletePopupComponent
    ],
    entryComponents: [
        GezinssituatieMySuffixComponent,
        GezinssituatieMySuffixUpdateComponent,
        GezinssituatieMySuffixDeleteDialogComponent,
        GezinssituatieMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationGezinssituatieMySuffixModule {}
