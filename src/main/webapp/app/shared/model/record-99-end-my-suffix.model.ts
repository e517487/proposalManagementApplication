import { Moment } from 'moment';

export interface IRecord99EndMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgnr?: number;
    creatieDatum?: Moment;
    creatieTijd?: Moment;
    aantalAanvragen?: number;
    aantalRegels?: number;
}

export class Record99EndMySuffix implements IRecord99EndMySuffix {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public recordType?: number,
        public volgnr?: number,
        public creatieDatum?: Moment,
        public creatieTijd?: Moment,
        public aantalAanvragen?: number,
        public aantalRegels?: number
    ) {}
}
