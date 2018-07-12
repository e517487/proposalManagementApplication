export interface IRecord62Uitleg {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    rol?: string;
    uitlegGezin?: string;
    uitlegInkomsten?: string;
    uitlegInPlatform?: string;
}

export class Record62Uitleg implements IRecord62Uitleg {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public recordType?: number,
        public volgNr?: number,
        public rol?: string,
        public uitlegGezin?: string,
        public uitlegInkomsten?: string,
        public uitlegInPlatform?: string
    ) {}
}
