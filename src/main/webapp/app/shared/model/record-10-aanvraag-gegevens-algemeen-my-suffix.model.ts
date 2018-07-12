import { Moment } from 'moment';

export interface IRecord10AanvraagGegevensAlgemeenMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    dealerNr?: string;
    productCode?: string;
    zoeknaam?: string;
    verkoper?: string;
    dealerTelnr?: string;
    acceptatie?: string;
    aanvangDatum?: Moment;
    aanvangTijd?: Moment;
    acceptatieDatum?: Moment;
    acceptatieTijd?: Moment;
    prtDatum?: Moment;
    invoerder?: string;
    acceptant?: string;
}

export class Record10AanvraagGegevensAlgemeenMySuffix implements IRecord10AanvraagGegevensAlgemeenMySuffix {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public recordType?: number,
        public volgNr?: number,
        public dealerNr?: string,
        public productCode?: string,
        public zoeknaam?: string,
        public verkoper?: string,
        public dealerTelnr?: string,
        public acceptatie?: string,
        public aanvangDatum?: Moment,
        public aanvangTijd?: Moment,
        public acceptatieDatum?: Moment,
        public acceptatieTijd?: Moment,
        public prtDatum?: Moment,
        public invoerder?: string,
        public acceptant?: string
    ) {}
}
