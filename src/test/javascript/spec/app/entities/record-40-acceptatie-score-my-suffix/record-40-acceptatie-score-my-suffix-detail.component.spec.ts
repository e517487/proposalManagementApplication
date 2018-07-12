/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreMySuffixDetailComponent } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix-detail.component';
import { Record40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';

describe('Component Tests', () => {
    describe('Record40AcceptatieScoreMySuffix Management Detail Component', () => {
        let comp: Record40AcceptatieScoreMySuffixDetailComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreMySuffixDetailComponent>;
        const route = ({ data: of({ record40AcceptatieScore: new Record40AcceptatieScoreMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record40AcceptatieScoreMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record40AcceptatieScoreMySuffixDetailComponent);
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
