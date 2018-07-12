import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ProposalManagementApplicationSharedModule } from 'app/shared';
import {
    Record25HerfinancieeringComponent,
    Record25HerfinancieeringDetailComponent,
    Record25HerfinancieeringUpdateComponent,
    Record25HerfinancieeringDeletePopupComponent,
    Record25HerfinancieeringDeleteDialogComponent,
    record25HerfinancieeringRoute,
    record25HerfinancieeringPopupRoute
} from './';

const ENTITY_STATES = [...record25HerfinancieeringRoute, ...record25HerfinancieeringPopupRoute];

@NgModule({
    imports: [ProposalManagementApplicationSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        Record25HerfinancieeringComponent,
        Record25HerfinancieeringDetailComponent,
        Record25HerfinancieeringUpdateComponent,
        Record25HerfinancieeringDeleteDialogComponent,
        Record25HerfinancieeringDeletePopupComponent
    ],
    entryComponents: [
        Record25HerfinancieeringComponent,
        Record25HerfinancieeringUpdateComponent,
        Record25HerfinancieeringDeleteDialogComponent,
        Record25HerfinancieeringDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationRecord25HerfinancieeringModule {}
