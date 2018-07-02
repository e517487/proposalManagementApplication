import { Moment } from 'moment';
import { INawWerkgeverUWVMySuffix } from 'app/shared/model//naw-werkgever-uwv-my-suffix.model';

export interface IWerksituatieMySuffix {
    id?: number;
    volgnummer?: number;
    beroep?: string;
    aardDienstverband?: string;
    beginDienstverbandDt?: Moment;
    nawWerkgeverUWVS?: INawWerkgeverUWVMySuffix[];
    fdnAanvragerId?: number;
}

export class WerksituatieMySuffix implements IWerksituatieMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public beroep?: string,
        public aardDienstverband?: string,
        public beginDienstverbandDt?: Moment,
        public nawWerkgeverUWVS?: INawWerkgeverUWVMySuffix[],
        public fdnAanvragerId?: number
    ) {}
}
