/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelComponent } from 'app/entities/record-20-financieel/record-20-financieel.component';
import { Record20FinancieelService } from 'app/entities/record-20-financieel/record-20-financieel.service';
import { Record20Financieel } from 'app/shared/model/record-20-financieel.model';

describe('Component Tests', () => {
    describe('Record20Financieel Management Component', () => {
        let comp: Record20FinancieelComponent;
        let fixture: ComponentFixture<Record20FinancieelComponent>;
        let service: Record20FinancieelService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelComponent],
                providers: []
            })
                .overrideTemplate(Record20FinancieelComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record20FinancieelComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record20FinancieelService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record20Financieel(123)],
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
