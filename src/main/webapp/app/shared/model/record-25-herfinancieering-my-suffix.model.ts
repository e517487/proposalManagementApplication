export interface IRecord25HerfinancieeringMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record25HerfinancieeringMySuffix implements IRecord25HerfinancieeringMySuffix {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
