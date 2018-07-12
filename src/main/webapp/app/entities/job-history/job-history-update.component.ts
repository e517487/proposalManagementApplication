import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IJobHistory } from 'app/shared/model/job-history.model';
import { JobHistoryService } from './job-history.service';
import { IJob } from 'app/shared/model/job.model';
import { JobService } from 'app/entities/job';
import { IDepartmentMySuffix } from 'app/shared/model/department-my-suffix.model';
import { DepartmentMySuffixService } from 'app/entities/department-my-suffix';
import { IEmployeeMySuffix } from 'app/shared/model/employee-my-suffix.model';
import { EmployeeMySuffixService } from 'app/entities/employee-my-suffix';

@Component({
    selector: 'jhi-job-history-update',
    templateUrl: './job-history-update.component.html'
})
export class JobHistoryUpdateComponent implements OnInit {
    private _jobHistory: IJobHistory;
    isSaving: boolean;

    jobs: IJob[];

    departments: IDepartmentMySuffix[];

    employees: IEmployeeMySuffix[];
    startDate: string;
    endDate: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private jobHistoryService: JobHistoryService,
        private jobService: JobService,
        private departmentService: DepartmentMySuffixService,
        private employeeService: EmployeeMySuffixService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ jobHistory }) => {
            this.jobHistory = jobHistory;
        });
        this.jobService.query({ filter: 'jobhistory-is-null' }).subscribe(
            (res: HttpResponse<IJob[]>) => {
                if (!this.jobHistory.job || !this.jobHistory.job.id) {
                    this.jobs = res.body;
                } else {
                    this.jobService.find(this.jobHistory.job.id).subscribe(
                        (subRes: HttpResponse<IJob>) => {
                            this.jobs = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.departmentService.query({ filter: 'jobhistory-is-null' }).subscribe(
            (res: HttpResponse<IDepartmentMySuffix[]>) => {
                if (!this.jobHistory.department || !this.jobHistory.department.id) {
                    this.departments = res.body;
                } else {
                    this.departmentService.find(this.jobHistory.department.id).subscribe(
                        (subRes: HttpResponse<IDepartmentMySuffix>) => {
                            this.departments = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.employeeService.query({ filter: 'jobhistory-is-null' }).subscribe(
            (res: HttpResponse<IEmployeeMySuffix[]>) => {
                if (!this.jobHistory.employee || !this.jobHistory.employee.id) {
                    this.employees = res.body;
                } else {
                    this.employeeService.find(this.jobHistory.employee.id).subscribe(
                        (subRes: HttpResponse<IEmployeeMySuffix>) => {
                            this.employees = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.jobHistory.startDate = moment(this.startDate, DATE_TIME_FORMAT);
        this.jobHistory.endDate = moment(this.endDate, DATE_TIME_FORMAT);
        if (this.jobHistory.id !== undefined) {
            this.subscribeToSaveResponse(this.jobHistoryService.update(this.jobHistory));
        } else {
            this.subscribeToSaveResponse(this.jobHistoryService.create(this.jobHistory));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IJobHistory>>) {
        result.subscribe((res: HttpResponse<IJobHistory>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackJobById(index: number, item: IJob) {
        return item.id;
    }

    trackDepartmentById(index: number, item: IDepartmentMySuffix) {
        return item.id;
    }

    trackEmployeeById(index: number, item: IEmployeeMySuffix) {
        return item.id;
    }
    get jobHistory() {
        return this._jobHistory;
    }

    set jobHistory(jobHistory: IJobHistory) {
        this._jobHistory = jobHistory;
        this.startDate = moment(jobHistory.startDate).format(DATE_TIME_FORMAT);
        this.endDate = moment(jobHistory.endDate).format(DATE_TIME_FORMAT);
    }
}
