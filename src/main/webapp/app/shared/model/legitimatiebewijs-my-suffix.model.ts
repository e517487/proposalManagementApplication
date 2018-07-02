export interface ILegitimatiebewijsMySuffix {
    id?: number;
    volgnummer?: number;
    soort?: string;
    land?: string;
    fdnAanvragerId?: number;
}

export class LegitimatiebewijsMySuffix implements ILegitimatiebewijsMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public soort?: string,
        public land?: string,
        public fdnAanvragerId?: number
    ) {}
}
