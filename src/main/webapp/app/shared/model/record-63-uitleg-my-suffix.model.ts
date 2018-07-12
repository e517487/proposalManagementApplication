export interface IRecord63UitlegMySuffix {
    id?: number;
    pcFinetNr?: string;
    recordType?: number;
    volgNr?: number;
    rol?: string;
    uitlegGezin?: string;
    uitlegInkomsten?: string;
    uitlegInPlatform?: string;
}

export class Record63UitlegMySuffix implements IRecord63UitlegMySuffix {
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
