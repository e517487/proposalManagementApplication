/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelDetailComponent } from 'app/entities/record-20-financieel/record-20-financieel-detail.component';
import { Record20Financieel } from 'app/shared/model/record-20-financieel.model';

describe('Component Tests', () => {
    describe('Record20Financieel Management Detail Component', () => {
        let comp: Record20FinancieelDetailComponent;
        let fixture: ComponentFixture<Record20FinancieelDetailComponent>;
        const route = ({ data: of({ record20Financieel: new Record20Financieel(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record20FinancieelDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record20FinancieelDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record20Financieel).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
