/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FinancieleSituatieMySuffixDetailComponent } from 'app/entities/financiele-situatie-my-suffix/financiele-situatie-my-suffix-detail.component';
import { FinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';

describe('Component Tests', () => {
    describe('FinancieleSituatieMySuffix Management Detail Component', () => {
        let comp: FinancieleSituatieMySuffixDetailComponent;
        let fixture: ComponentFixture<FinancieleSituatieMySuffixDetailComponent>;
        const route = ({ data: of({ financieleSituatie: new FinancieleSituatieMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FinancieleSituatieMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(FinancieleSituatieMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FinancieleSituatieMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.financieleSituatie).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
