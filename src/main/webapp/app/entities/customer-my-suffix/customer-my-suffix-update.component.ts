import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ICustomerMySuffix } from 'app/shared/model/customer-my-suffix.model';
import { CustomerMySuffixService } from './customer-my-suffix.service';

@Component({
    selector: 'jhi-customer-my-suffix-update',
    templateUrl: './customer-my-suffix-update.component.html'
})
export class CustomerMySuffixUpdateComponent implements OnInit {
    private _customer: ICustomerMySuffix;
    isSaving: boolean;

    constructor(private customerService: CustomerMySuffixService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ customer }) => {
            this.customer = customer;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.customer.id !== undefined) {
            this.subscribeToSaveResponse(this.customerService.update(this.customer));
        } else {
            this.subscribeToSaveResponse(this.customerService.create(this.customer));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ICustomerMySuffix>>) {
        result.subscribe((res: HttpResponse<ICustomerMySuffix>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get customer() {
        return this._customer;
    }

    set customer(customer: ICustomerMySuffix) {
        this._customer = customer;
    }
}
