export interface IRekenmoduleAanvraagMySuffix {
    id?: number;
    rekenmoduleAanvraagFileName?: string;
    requestId?: number;
    aanvraagberichtId?: number;
}

export class RekenmoduleAanvraagMySuffix implements IRekenmoduleAanvraagMySuffix {
    constructor(
        public id?: number,
        public rekenmoduleAanvraagFileName?: string,
        public requestId?: number,
        public aanvraagberichtId?: number
    ) {}
}
