import { Moment } from 'moment';

export interface IHeaderMySuffix {
    id?: number;
    emailZender?: string;
    emailOntvanger?: string;
    ontvangerNaam?: string;
    lognaam?: string;
    messageRef?: string;
    berichtVersie?: number;
    verzendDt?: Moment;
    verzendTijd?: Moment;
    aanvraagberichtId?: number;
}

export class HeaderMySuffix implements IHeaderMySuffix {
    constructor(
        public id?: number,
        public emailZender?: string,
        public emailOntvanger?: string,
        public ontvangerNaam?: string,
        public lognaam?: string,
        public messageRef?: string,
        public berichtVersie?: number,
        public verzendDt?: Moment,
        public verzendTijd?: Moment,
        public aanvraagberichtId?: number
    ) {}
}
