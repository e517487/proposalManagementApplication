export interface IRecord11AanvraagGegevensOpmerkingen {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
}

export class Record11AanvraagGegevensOpmerkingen implements IRecord11AanvraagGegevensOpmerkingen {
    constructor(public id?: number, public pcFinetNr?: string, public recordType?: number, public volgNr?: number) {}
}
