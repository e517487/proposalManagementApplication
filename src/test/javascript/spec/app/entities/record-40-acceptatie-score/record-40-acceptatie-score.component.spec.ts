/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreComponent } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score.component';
import { Record40AcceptatieScoreService } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score.service';
import { Record40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';

describe('Component Tests', () => {
    describe('Record40AcceptatieScore Management Component', () => {
        let comp: Record40AcceptatieScoreComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreComponent>;
        let service: Record40AcceptatieScoreService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreComponent],
                providers: []
            })
                .overrideTemplate(Record40AcceptatieScoreComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record40AcceptatieScoreComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record40AcceptatieScoreService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record40AcceptatieScore(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record40AcceptatieScores[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
