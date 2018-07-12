import { Moment } from 'moment';

export interface IRecord01Start {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    creatieDatum?: Moment;
    creatieTijd?: Moment;
}

export class Record01Start implements IRecord01Start {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public recordType?: number,
        public volgNr?: number,
        public creatieDatum?: Moment,
        public creatieTijd?: Moment
    ) {}
}
