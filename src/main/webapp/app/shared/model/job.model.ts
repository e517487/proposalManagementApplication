import { ITaskMySuffix } from 'app/shared/model//task-my-suffix.model';
import { IEmployeeMySuffix } from 'app/shared/model//employee-my-suffix.model';

export interface IJob {
    id?: number;
    jobTitle?: string;
    minSalary?: number;
    maxSalary?: number;
    tasks?: ITaskMySuffix[];
    employee?: IEmployeeMySuffix;
}

export class Job implements IJob {
    constructor(
        public id?: number,
        public jobTitle?: string,
        public minSalary?: number,
        public maxSalary?: number,
        public tasks?: ITaskMySuffix[],
        public employee?: IEmployeeMySuffix
    ) {}
}
