import { Moment } from 'moment';
import { IJob } from 'app/shared/model//job.model';
import { IDepartmentMySuffix } from 'app/shared/model//department-my-suffix.model';
import { IEmployeeMySuffix } from 'app/shared/model//employee-my-suffix.model';

export const enum Language {
    FRENCH = 'FRENCH',
    ENGLISH = 'ENGLISH',
    DUTCH = 'DUTCH'
}

export interface IJobHistory {
    id?: number;
    startDate?: Moment;
    endDate?: Moment;
    language?: Language;
    job?: IJob;
    department?: IDepartmentMySuffix;
    employee?: IEmployeeMySuffix;
}

export class JobHistory implements IJobHistory {
    constructor(
        public id?: number,
        public startDate?: Moment,
        public endDate?: Moment,
        public language?: Language,
        public job?: IJob,
        public department?: IDepartmentMySuffix,
        public employee?: IEmployeeMySuffix
    ) {}
}
