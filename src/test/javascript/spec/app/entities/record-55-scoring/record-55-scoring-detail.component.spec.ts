/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringDetailComponent } from 'app/entities/record-55-scoring/record-55-scoring-detail.component';
import { Record55Scoring } from 'app/shared/model/record-55-scoring.model';

describe('Component Tests', () => {
    describe('Record55Scoring Management Detail Component', () => {
        let comp: Record55ScoringDetailComponent;
        let fixture: ComponentFixture<Record55ScoringDetailComponent>;
        const route = ({ data: of({ record55Scoring: new Record55Scoring(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record55ScoringDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record55ScoringDetailComponent);
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
