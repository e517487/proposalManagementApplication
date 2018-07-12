export interface IRecord50BedrijfMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record50BedrijfMySuffix implements IRecord50BedrijfMySuffix {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
