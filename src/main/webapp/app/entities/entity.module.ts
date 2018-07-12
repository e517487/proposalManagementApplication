import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ProposalManagementApplicationRecord01StartMySuffixModule } from './record-01-start-my-suffix/record-01-start-my-suffix.module';
import { ProposalManagementApplicationRecord99EndMySuffixModule } from './record-99-end-my-suffix/record-99-end-my-suffix.module';
// prettier-ignore
import {
    ProposalManagementApplicationRecord10AanvraagGegevensAlgemeenMySuffixModule
} from './record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix.module';
// prettier-ignore
import {
    ProposalManagementApplicationRecord11AanvraagGegevensOpmerkingenMySuffixModule
} from './record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix.module';
import { ProposalManagementApplicationRecord20FinancieelMySuffixModule } from './record-20-financieel-my-suffix/record-20-financieel-my-suffix.module';
import { ProposalManagementApplicationRecord25HerfinancieeringMySuffixModule } from './record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix.module';
import { ProposalManagementApplicationRecord30InruilMySuffixModule } from './record-30-inruil-my-suffix/record-30-inruil-my-suffix.module';
import { ProposalManagementApplicationRecord35ObjectMySuffixModule } from './record-35-object-my-suffix/record-35-object-my-suffix.module';
import { ProposalManagementApplicationRecord40AcceptatieScoreMySuffixModule } from './record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix.module';
import { ProposalManagementApplicationRecord45RelatieMySuffixModule } from './record-45-relatie-my-suffix/record-45-relatie-my-suffix.module';
// prettier-ignore
import {
    ProposalManagementApplicationRecord46RelatieHuishoudelijkMySuffixModule
} from './record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix.module';
import { ProposalManagementApplicationRecord50BedrijfMySuffixModule } from './record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix.module';
import { ProposalManagementApplicationRecord55ScoringMySuffixModule } from './record-55-scoring-my-suffix/record-55-scoring-my-suffix.module';
import { ProposalManagementApplicationRecord61UitlegMySuffixModule } from './record-61-uitleg-my-suffix/record-61-uitleg-my-suffix.module';
import { ProposalManagementApplicationRecord62UitlegMySuffixModule } from './record-62-uitleg-my-suffix/record-62-uitleg-my-suffix.module';
import { ProposalManagementApplicationRecord63UitlegMySuffixModule } from './record-63-uitleg-my-suffix/record-63-uitleg-my-suffix.module';
import { ProposalManagementApplicationJobHistoryMySuffixModule } from './job-history-my-suffix/job-history-my-suffix.module';
import { ProposalManagementApplicationRecord99EindMySuffixModule } from './record-99-eind-my-suffix/record-99-eind-my-suffix.module';
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
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        ProposalManagementApplicationRecord01StartMySuffixModule,
        ProposalManagementApplicationRecord99EndMySuffixModule,
        ProposalManagementApplicationRecord10AanvraagGegevensAlgemeenMySuffixModule,
        ProposalManagementApplicationRecord11AanvraagGegevensOpmerkingenMySuffixModule,
        ProposalManagementApplicationRecord20FinancieelMySuffixModule,
        ProposalManagementApplicationRecord25HerfinancieeringMySuffixModule,
        ProposalManagementApplicationRecord30InruilMySuffixModule,
        ProposalManagementApplicationRecord35ObjectMySuffixModule,
        ProposalManagementApplicationRecord40AcceptatieScoreMySuffixModule,
        ProposalManagementApplicationRecord45RelatieMySuffixModule,
        ProposalManagementApplicationRecord46RelatieHuishoudelijkMySuffixModule,
        ProposalManagementApplicationRecord50BedrijfMySuffixModule,
        ProposalManagementApplicationRecord55ScoringMySuffixModule,
        ProposalManagementApplicationRecord61UitlegMySuffixModule,
        ProposalManagementApplicationRecord62UitlegMySuffixModule,
        ProposalManagementApplicationRecord63UitlegMySuffixModule,
        ProposalManagementApplicationJobHistoryMySuffixModule,
        ProposalManagementApplicationRecord99EindMySuffixModule,
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
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ProposalManagementApplicationEntityModule {}
