/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelMySuffixComponent } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix.component';
import { Record20FinancieelMySuffixService } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix.service';
import { Record20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';

describe('Component Tests', () => {
    describe('Record20FinancieelMySuffix Management Component', () => {
        let comp: Record20FinancieelMySuffixComponent;
        let fixture: ComponentFixture<Record20FinancieelMySuffixComponent>;
        let service: Record20FinancieelMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record20FinancieelMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record20FinancieelMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record20FinancieelMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record20FinancieelMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record20Financieels[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
