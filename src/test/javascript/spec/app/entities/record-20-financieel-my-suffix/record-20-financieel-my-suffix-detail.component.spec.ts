/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelMySuffixDetailComponent } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix-detail.component';
import { Record20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';

describe('Component Tests', () => {
    describe('Record20FinancieelMySuffix Management Detail Component', () => {
        let comp: Record20FinancieelMySuffixDetailComponent;
        let fixture: ComponentFixture<Record20FinancieelMySuffixDetailComponent>;
        const route = ({ data: of({ record20Financieel: new Record20FinancieelMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record20FinancieelMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record20FinancieelMySuffixDetailComponent);
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
