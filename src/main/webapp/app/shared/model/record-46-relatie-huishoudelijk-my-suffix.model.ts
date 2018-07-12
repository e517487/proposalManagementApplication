export interface IRecord46RelatieHuishoudelijkMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record46RelatieHuishoudelijkMySuffix implements IRecord46RelatieHuishoudelijkMySuffix {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
