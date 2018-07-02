export interface IAdresMySuffix {
    id?: number;
    volgnummer?: number;
    soortAdres?: string;
    straatNaam?: string;
    huisNr?: string;
    plaatsNaam?: string;
    postcode?: string;
    land?: string;
    fdnAanvragerId?: number;
}

export class AdresMySuffix implements IAdresMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public soortAdres?: string,
        public straatNaam?: string,
        public huisNr?: string,
        public plaatsNaam?: string,
        public postcode?: string,
        public land?: string,
        public fdnAanvragerId?: number
    ) {}
}
