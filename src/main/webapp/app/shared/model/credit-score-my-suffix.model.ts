export interface ICreditScoreMySuffix {
    id?: number;
    requestId?: number;
}

export class CreditScoreMySuffix implements ICreditScoreMySuffix {
    constructor(public id?: number, public requestId?: number) {}
}
