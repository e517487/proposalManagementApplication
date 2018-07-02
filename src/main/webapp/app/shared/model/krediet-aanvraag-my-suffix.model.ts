export interface IKredietAanvraagMySuffix {
    id?: number;
    volgnummer?: number;
    duurInMnd?: string;
    soortAanvraag?: string;
    produktCodeNaam?: string;
    leningBedrag?: number;
    mndAflosBedrag?: number;
    gevrBedrInHanden?: number;
    zekerheid?: string;
    bestedingsdoel?: string;
    merkObject?: string;
    typeObject?: string;
    bouwjaarObject?: string;
    koopsomWaardeObj?: string;
    kenteken?: string;
    chassisnr?: string;
    inruilbedrag?: number;
    doelNieuw?: string;
    aanbetalingbedrag?: number;
    modelObject?: string;
    sparen?: string;
    typeTarief?: string;
    tariefNaam?: string;
    soortContract?: string;
    kontraktNaam?: string;
    produktNr?: string;
    perspectief?: string;
    nieuwGebruikt?: string;
    verkoopprijs?: number;
    aanbetaling?: number;
    overnameLopendeLening?: string;
    kredietSom?: number;
    gMI?: string;
    overnameKentekennr?: string;
    overnameFinanMy?: string;
    ovvrnameContractNr?: string;
    overnamePlaats?: string;
    duurinMnd?: string;
    restantbetaling?: number;
    effectiveRente?: string;
    verkoper?: string;
    aanvraagberichtId?: number;
}

export class KredietAanvraagMySuffix implements IKredietAanvraagMySuffix {
    constructor(
        public id?: number,
        public volgnummer?: number,
        public duurInMnd?: string,
        public soortAanvraag?: string,
        public produktCodeNaam?: string,
        public leningBedrag?: number,
        public mndAflosBedrag?: number,
        public gevrBedrInHanden?: number,
        public zekerheid?: string,
        public bestedingsdoel?: string,
        public merkObject?: string,
        public typeObject?: string,
        public bouwjaarObject?: string,
        public koopsomWaardeObj?: string,
        public kenteken?: string,
        public chassisnr?: string,
        public inruilbedrag?: number,
        public doelNieuw?: string,
        public aanbetalingbedrag?: number,
        public modelObject?: string,
        public sparen?: string,
        public typeTarief?: string,
        public tariefNaam?: string,
        public soortContract?: string,
        public kontraktNaam?: string,
        public produktNr?: string,
        public perspectief?: string,
        public nieuwGebruikt?: string,
        public verkoopprijs?: number,
        public aanbetaling?: number,
        public overnameLopendeLening?: string,
        public kredietSom?: number,
        public gMI?: string,
        public overnameKentekennr?: string,
        public overnameFinanMy?: string,
        public ovvrnameContractNr?: string,
        public overnamePlaats?: string,
        public duurinMnd?: string,
        public restantbetaling?: number,
        public effectiveRente?: string,
        public verkoper?: string,
        public aanvraagberichtId?: number
    ) {}
}
