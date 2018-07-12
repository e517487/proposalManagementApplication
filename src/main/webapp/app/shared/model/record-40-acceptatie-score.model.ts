export interface IRecord40AcceptatieScore {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record40AcceptatieScore implements IRecord40AcceptatieScore {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
