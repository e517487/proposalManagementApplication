import { Moment } from 'moment';

export interface IAlgemeenMySuffix {
    id?: number;
    viewcode?: string;
    versiecode?: string;
    valuta?: string;
    aanvraagVersie?: number;
    aanvraagVolgNr?: number;
    tussenpersoonNr?: number;
    bedrijfsnaamTp?: string;
    contactPersoonTp?: string;
    maatschappij?: string;
    registratieDt?: Moment;
    subagentNr?: number;
    verkopersNaam?: string;
    aanvraagberichtId?: number;
}

export class AlgemeenMySuffix implements IAlgemeenMySuffix {
    constructor(
        public id?: number,
        public viewcode?: string,
        public versiecode?: string,
        public valuta?: string,
        public aanvraagVersie?: number,
        public aanvraagVolgNr?: number,
        public tussenpersoonNr?: number,
        public bedrijfsnaamTp?: string,
        public contactPersoonTp?: string,
        public maatschappij?: string,
        public registratieDt?: Moment,
        public subagentNr?: number,
        public verkopersNaam?: string,
        public aanvraagberichtId?: number
    ) {}
}
