export interface ITekstRegelMySuffix {
    id?: number;
    regelnummer?: number;
    tekst?: string;
    vrijeTekstId?: number;
}

export class TekstRegelMySuffix implements ITekstRegelMySuffix {
    constructor(public id?: number, public regelnummer?: number, public tekst?: string, public vrijeTekstId?: number) {}
}
