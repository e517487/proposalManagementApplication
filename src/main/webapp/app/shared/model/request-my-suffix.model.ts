export interface IRequestMySuffix {
    id?: number;
    rekenmoduleAanvraagId?: number;
    creditScoreId?: number;
    customerId?: number;
}

export class RequestMySuffix implements IRequestMySuffix {
    constructor(public id?: number, public rekenmoduleAanvraagId?: number, public creditScoreId?: number, public customerId?: number) {}
}
