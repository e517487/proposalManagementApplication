import { IFdnAanvragerMySuffix } from 'app/shared/model//fdn-aanvrager-my-suffix.model';
import { IKredietAanvraagMySuffix } from 'app/shared/model//krediet-aanvraag-my-suffix.model';
import { IVrijeTekstMySuffix } from 'app/shared/model//vrije-tekst-my-suffix.model';

export interface IAanvraagberichtMySuffix {
    id?: number;
    rekenmoduleAanvraagId?: number;
    headerId?: number;
    algemeenId?: number;
    fdnAanvragers?: IFdnAanvragerMySuffix[];
    kredietAanvraags?: IKredietAanvraagMySuffix[];
    vrijeTeksts?: IVrijeTekstMySuffix[];
}

export class AanvraagberichtMySuffix implements IAanvraagberichtMySuffix {
    constructor(
        public id?: number,
        public rekenmoduleAanvraagId?: number,
        public headerId?: number,
        public algemeenId?: number,
        public fdnAanvragers?: IFdnAanvragerMySuffix[],
        public kredietAanvraags?: IKredietAanvraagMySuffix[],
        public vrijeTeksts?: IVrijeTekstMySuffix[]
    ) {}
}
