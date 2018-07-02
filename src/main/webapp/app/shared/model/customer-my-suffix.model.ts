import { IRequestMySuffix } from 'app/shared/model//request-my-suffix.model';

export interface ICustomerMySuffix {
    id?: number;
    requests?: IRequestMySuffix[];
}

export class CustomerMySuffix implements ICustomerMySuffix {
    constructor(public id?: number, public requests?: IRequestMySuffix[]) {}
}
