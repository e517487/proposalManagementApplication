import { Moment } from 'moment';

export interface IRecord01StartMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    creatieDatum?: Moment;
    creatieTijd?: Moment;
}

export class Record01StartMySuffix implements IRecord01StartMySuffix {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public recordType?: number,
        public volgNr?: number,
        public creatieDatum?: Moment,
        public creatieTijd?: Moment
    ) {}
}
