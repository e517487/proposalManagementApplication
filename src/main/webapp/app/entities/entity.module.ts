import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ProposalManagementApplicationRequestMySuffixModule } from './request-my-suffix/request-my-suffix.module';
import { ProposalManagementApplicationCreditScoreMySuffixModule } from './credit-score-my-suffix/credit-score-my-suffix.module';
import { ProposalManagementApplicationCustomerMySuffixModule } from './customer-my-suffix/customer-my-suffix.module';
import { ProposalManagementApplicationRekenmoduleAanvraagMySuffixModule } from './rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix.module';
import { ProposalManagementApplicationAanvraagberichtMySuffixModule } from './aanvraagbericht-my-suffix/aanvraagbericht-my-suffix.module';
import { ProposalManagementApplicationHeaderMySuffixModule } from './header-my-suffix/header-my-suffix.module';
import { ProposalManagementApplicationAlgemeenMySuffixModule } from './algemeen-my-suffix/algemeen-my-suffix.module';
import { ProposalManagementApplicationFdnAanvragerMySuffixModule } from './fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix.module';
import { ProposalManagementApplicationAdresMySuffixModule } from './adres-my-suffix/adres-my-suffix.module';
import { ProposalManagementApplicationLegitimatiebewijsMySuffixModule } from './legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix.module';
import { ProposalManagementApplicationWerksituatieMySuffixModule } from './werksituatie-my-suffix/werksituatie-my-suffix.module';
import { ProposalManagementApplicationNawWerkgeverUWVMySuffixModule } from './naw-werkgever-uwv-my-suffix/naw-werkgever-uwv-my-suffix.module';
import { ProposalManagementApplicationGezinssituatieMySuffixModule } from './gezinssituatie-my-suffix/gezinssituatie-my-suffix.module';
import { ProposalManagementApplicationFinancieleSituatieMySuffixModule } from './financiele-situatie-my-suffix/financiele-situatie-my-suffix.module';
import { ProposalManagementApplicationKredietAanvraagMySuffixModule } from './krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix.module';
import { ProposalManagementApplicationVrijeTekstMySuffixModule } from './vrije-tekst-my-suffix/vrije-tekst-my-suffix.module';
import { ProposalManagementApplicationTekstRegelMySuffixModule } from './tekst-regel-my-suffix/tekst-regel-my-suffix.module';
import { ProposalManagementApplicationRegionMySuffixModule } from './region-my-suffix/region-my-suffix.module';
import { ProposalManagementApplicationCountryMySuffixModule } from './country-my-suffix/country-my-suffix.module';
import { ProposalManagementApplicationLocationMySuffixModule } from './location-my-suffix/location-my-suffix.module';
import { ProposalManagementApplicationDepartmentMySuffixModule } from './department-my-suffix/department-my-suffix.module';
import { ProposalManagementApplicationTaskMySuffixModule } from './task-my-suffix/task-my-suffix.module';
import { ProposalManagementApplicationEmployeeMySuffixModule } from './employee-my-suffix/employee-my-suffix.module';
import { ProposalManagementApplicationJobMySuffixModule } from './job-my-suffix/job-my-suffix.module';
import { ProposalManagementApplicationJobHistoryMySuffixModule } from './job-history-my-suffix/job-history-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        ProposalManagementApplicationRequestMySuffixModule,
        ProposalManagementApplicationCreditScoreMySuffixModule,
        ProposalManagementApplicationCustomerMySuffixModule,
        ProposalManagementApplicationRekenmoduleAanvraagMySuffixModule,
        ProposalManagementApplicationAanvraagberichtMySuffixModule,
        ProposalManagementApplicationHeaderMySuffixModule,
        ProposalManagementApplicationAlgemeenMySuffixModule,
        ProposalManagementApplicationFdnAanvragerMySuffixModule,
        ProposalManagementApplicationAdresMySuffixModule,
        ProposalManagementApplicationLegitimatiebewijsMySuffixModule,
        ProposalManagementApplicationWerksituatieMySuffixModule,
        ProposalManagementApplicationNawWerkgeverUWVMySuffixModule,
        ProposalManagementApplicationGezinssituatieMySuffixModule,
        ProposalManagementApplicationFinancieleSituatieMySuffixModule,
        ProposalManagementApplicationKredietAanvraagMySuffixModule,
        ProposalManagementApplicationVrijeTekstMySuffixModule,
        ProposalManagementApplicationTekstRegelMySuffixModule,
        ProposalManagementApplicationRegionMySuffixModule,
        ProposalManagementApplicationCountryMySuffixModule,
        ProposalManagementApplicationLocationMySuffixModule,
        ProposalManagementApplicationDepartmentMySuffixModule,
        ProposalManagementApplicationTaskMySuffixModule,
        ProposalManagementApplicationEmployeeMySuffixModule,
        ProposalManagementApplicationJobMySuffixModule,
        ProposalManagementApplicationJobHistoryMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationEntityModule {}
