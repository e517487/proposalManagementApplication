import { Moment } from 'moment';

export interface IRecord99Eind {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    creatieDatum?: Moment;
    creatieTijd?: Moment;
    aantalAanvragen?: number;
    aantalRegels?: number;
}

export class Record99Eind implements IRecord99Eind {
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
