export interface IRecord30InruilMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record30InruilMySuffix implements IRecord30InruilMySuffix {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
