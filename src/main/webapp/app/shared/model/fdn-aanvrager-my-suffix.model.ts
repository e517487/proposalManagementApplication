import { Moment } from 'moment';
import { IAdresMySuffix } from 'app/shared/model//adres-my-suffix.model';
import { ILegitimatiebewijsMySuffix } from 'app/shared/model//legitimatiebewijs-my-suffix.model';
import { IWerksituatieMySuffix } from 'app/shared/model//werksituatie-my-suffix.model';
import { IGezinssituatieMySuffix } from 'app/shared/model//gezinssituatie-my-suffix.model';
import { IFinancieleSituatieMySuffix } from 'app/shared/model//financiele-situatie-my-suffix.model';

export interface IFdnAanvragerMySuffix {
    id?: number;
    volgnummer?: number;
    soortAanvrager?: string;
    achterNaam?: string;
    voorletters?: string;
    gebNaam?: string;
    woonachtigHuidigDt?: Moment;
    telBereikbaar?: string;
    telefoonNrPrive?: string;
    iban?: string;
    geboorteDt?: Moment;
    nationaliteit?: string;
    geslacht?: string;
    sociaalFiscaalNr?: string;
    relatieTp?: string;
    adres?: IAdresMySuffix[];
    legitimatiebewijs?: ILegitimatiebewijsMySuffix[];
    werksituaties?: IWerksituatieMySuffix[];
    gezinssituaties?: IGezinssituatieMySuffix[];
    financieleSituaties?: IFinancieleSituatieMySuffix[];
    aanvraagberichtId?: number;
}

export class FdnAanvragerMySuffix implements IFdnAanvragerMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public soortAanvrager?: string,
        public achterNaam?: string,
        public voorletters?: string,
        public gebNaam?: string,
        public woonachtigHuidigDt?: Moment,
        public telBereikbaar?: string,
        public telefoonNrPrive?: string,
        public iban?: string,
        public geboorteDt?: Moment,
        public nationaliteit?: string,
        public geslacht?: string,
        public sociaalFiscaalNr?: string,
        public relatieTp?: string,
        public adres?: IAdresMySuffix[],
        public legitimatiebewijs?: ILegitimatiebewijsMySuffix[],
        public werksituaties?: IWerksituatieMySuffix[],
        public gezinssituaties?: IGezinssituatieMySuffix[],
        public financieleSituaties?: IFinancieleSituatieMySuffix[],
        public aanvraagberichtId?: number
    ) {}
}
