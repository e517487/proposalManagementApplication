export interface IRequestMySuffix {
    id?: number;
    pcFinetNr?: string;
    rekenmoduleAanvraagId?: number;
    creditScoreId?: number;
    customerId?: number;
}

export class RequestMySuffix implements IRequestMySuffix {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public rekenmoduleAanvraagId?: number,
        public creditScoreId?: number,
        public customerId?: number
    ) {}
}
