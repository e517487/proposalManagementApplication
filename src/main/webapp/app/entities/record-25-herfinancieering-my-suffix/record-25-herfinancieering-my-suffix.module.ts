import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record25HerfinancieeringMySuffixComponent,
    Record25HerfinancieeringMySuffixDetailComponent,
    Record25HerfinancieeringMySuffixUpdateComponent,
    Record25HerfinancieeringMySuffixDeletePopupComponent,
    Record25HerfinancieeringMySuffixDeleteDialogComponent,
    record25HerfinancieeringRoute,
    record25HerfinancieeringPopupRoute
} from './';

const ENTITY_STATES = [...record25HerfinancieeringRoute, ...record25HerfinancieeringPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record25HerfinancieeringMySuffixComponent,
        Record25HerfinancieeringMySuffixDetailComponent,
        Record25HerfinancieeringMySuffixUpdateComponent,
        Record25HerfinancieeringMySuffixDeleteDialogComponent,
        Record25HerfinancieeringMySuffixDeletePopupComponent
    ],
    entryComponents: [
        Record25HerfinancieeringMySuffixComponent,
        Record25HerfinancieeringMySuffixUpdateComponent,
        Record25HerfinancieeringMySuffixDeleteDialogComponent,
        Record25HerfinancieeringMySuffixDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord25HerfinancieeringMySuffixModule {}
