import { ITekstRegelMySuffix } from 'app/shared/model//tekst-regel-my-suffix.model';

export interface IVrijeTekstMySuffix {
    id?: number;
    volgnummer?: number;
    tekstRegels?: ITekstRegelMySuffix[];
    aanvraagberichtId?: number;
}

export class VrijeTekstMySuffix implements IVrijeTekstMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public tekstRegels?: ITekstRegelMySuffix[],
        public aanvraagberichtId?: number
    ) {}
}
