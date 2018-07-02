export interface INawWerkgeverUWVMySuffix {
    id?: number;
    volgnummer?: number;
    naam?: string;
    plaatsNaam?: string;
    werksituatieId?: number;
}

export class NawWerkgeverUWVMySuffix implements INawWerkgeverUWVMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public naam?: string,
        public plaatsNaam?: string,
        public werksituatieId?: number
    ) {}
}
