import { Moment } from 'moment';

export interface IRecord99EindMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    creatieDatum?: Moment;
    creatieTijd?: Moment;
    aantalAanvragen?: number;
    aantalRegels?: number;
}

export class Record99EindMySuffix implements IRecord99EindMySuffix {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public recordType?: number,
        public volgNr?: number,
        public creatieDatum?: Moment,
        public creatieTijd?: Moment,
        public aantalAanvragen?: number,
        public aantalRegels?: number
    ) {}
}
