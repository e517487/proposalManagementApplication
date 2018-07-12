export interface IRecord62UitlegMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    rol?: string;
    uitlegGezin?: string;
    uitlegInkomsten?: string;
    uitlegInPlatform?: string;
}

export class Record62UitlegMySuffix implements IRecord62UitlegMySuffix {
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
