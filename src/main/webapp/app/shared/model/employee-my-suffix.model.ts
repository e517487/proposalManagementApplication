import { Moment } from 'moment';
import { IJob } from 'app/shared/model//job.model';
import { IEmployeeMySuffix } from 'app/shared/model//employee-my-suffix.model';
import { IDepartmentMySuffix } from 'app/shared/model//department-my-suffix.model';

export interface IEmployeeMySuffix {
    id?: number;
    firstName?: string;
    lastName?: string;
    email?: string;
    phoneNumber?: string;
    hireDate?: Moment;
    salary?: number;
    commissionPct?: number;
    jobs?: IJob[];
    manager?: IEmployeeMySuffix;
    department?: IDepartmentMySuffix;
}

export class EmployeeMySuffix implements IEmployeeMySuffix {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string,
        public email?: string,
        public phoneNumber?: string,
        public hireDate?: Moment,
        public salary?: number,
        public commissionPct?: number,
        public jobs?: IJob[],
        public manager?: IEmployeeMySuffix,
        public department?: IDepartmentMySuffix
    ) {}
}
