export interface IRecord40AcceptatieScoreMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record40AcceptatieScoreMySuffix implements IRecord40AcceptatieScoreMySuffix {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
