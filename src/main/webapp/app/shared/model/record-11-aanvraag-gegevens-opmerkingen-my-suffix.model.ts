export interface IRecord11AanvraagGegevensOpmerkingenMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record11AanvraagGegevensOpmerkingenMySuffix implements IRecord11AanvraagGegevensOpmerkingenMySuffix {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
