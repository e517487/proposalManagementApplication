/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringMySuffixDetailComponent } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix-detail.component';
import { Record55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';

describe('Component Tests', () => {
    describe('Record55ScoringMySuffix Management Detail Component', () => {
        let comp: Record55ScoringMySuffixDetailComponent;
        let fixture: ComponentFixture<Record55ScoringMySuffixDetailComponent>;
        const route = ({ data: of({ record55Scoring: new Record55ScoringMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record55ScoringMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record55ScoringMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record55Scoring).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
