/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { CreditScoreMySuffixDetailComponent } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix-detail.component';
import { CreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';

describe('Component Tests', () => {
    describe('CreditScoreMySuffix Management Detail Component', () => {
        let comp: CreditScoreMySuffixDetailComponent;
        let fixture: ComponentFixture<CreditScoreMySuffixDetailComponent>;
        const route = ({ data: of({ creditScore: new CreditScoreMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [CreditScoreMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(CreditScoreMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CreditScoreMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.creditScore).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
