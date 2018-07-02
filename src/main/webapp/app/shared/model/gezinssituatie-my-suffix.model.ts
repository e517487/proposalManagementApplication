export interface IGezinssituatieMySuffix {
    id?: number;
    volgnummer?: number;
    burgerlijkeStaat?: string;
    huwelijkseVw?: string;
    huwelijkOntbonden?: string;
    weduweWeduwnaar?: string;
    kinderenAantal?: number;
    fdnAanvragerId?: number;
}

export class GezinssituatieMySuffix implements IGezinssituatieMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public burgerlijkeStaat?: string,
        public huwelijkseVw?: string,
        public huwelijkOntbonden?: string,
        public weduweWeduwnaar?: string,
        public kinderenAantal?: number,
        public fdnAanvragerId?: number
    ) {}
}
