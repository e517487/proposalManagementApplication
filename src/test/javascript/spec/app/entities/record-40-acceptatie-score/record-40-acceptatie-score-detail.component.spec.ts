/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreDetailComponent } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score-detail.component';
import { Record40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';

describe('Component Tests', () => {
    describe('Record40AcceptatieScore Management Detail Component', () => {
        let comp: Record40AcceptatieScoreDetailComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreDetailComponent>;
        const route = ({ data: of({ record40AcceptatieScore: new Record40AcceptatieScore(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record40AcceptatieScoreDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record40AcceptatieScoreDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record40AcceptatieScore).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
