export interface IFinancieleSituatieMySuffix {
    id?: number;
    volgnummer?: number;
    brutoMaandInk?: number;
    nettoMaandInk?: number;
    voorlopigeTeruggaaf?: string;
    eigenWoning?: string;
    hypotheek?: string;
    brutoMndHypotheek?: number;
    lopendeLeningen?: string;
    woonsituatie?: string;
    woonlasten?: number;
    fdnAanvragerId?: number;
}

export class FinancieleSituatieMySuffix implements IFinancieleSituatieMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public brutoMaandInk?: number,
        public nettoMaandInk?: number,
        public voorlopigeTeruggaaf?: string,
        public eigenWoning?: string,
        public hypotheek?: string,
        public brutoMndHypotheek?: number,
        public lopendeLeningen?: string,
        public woonsituatie?: string,
        public woonlasten?: number,
        public fdnAanvragerId?: number
    ) {}
}
