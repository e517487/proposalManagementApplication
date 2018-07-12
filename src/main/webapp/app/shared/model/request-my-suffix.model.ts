export interface IRequestMySuffix {
    id?: number;
    pcFinetNr?: string;
    creditScoreId?: number;
    rekenmoduleAanvraagId?: number;
    customerId?: number;
}

export class RequestMySuffix implements IRequestMySuffix {
    constructor(
        public id?: number,
        public pcFinetNr?: string,
        public creditScoreId?: number,
        public rekenmoduleAanvraagId?: number,
        public customerId?: number
    ) {}
}
