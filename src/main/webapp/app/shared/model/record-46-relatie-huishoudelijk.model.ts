export interface IRecord46RelatieHuishoudelijk {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record46RelatieHuishoudelijk implements IRecord46RelatieHuishoudelijk {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
