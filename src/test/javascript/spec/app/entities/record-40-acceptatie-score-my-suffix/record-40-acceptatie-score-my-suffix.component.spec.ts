/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreMySuffixComponent } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix.component';
import { Record40AcceptatieScoreMySuffixService } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix.service';
import { Record40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';

describe('Component Tests', () => {
    describe('Record40AcceptatieScoreMySuffix Management Component', () => {
        let comp: Record40AcceptatieScoreMySuffixComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreMySuffixComponent>;
        let service: Record40AcceptatieScoreMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record40AcceptatieScoreMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record40AcceptatieScoreMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record40AcceptatieScoreMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record40AcceptatieScoreMySuffix(123)],
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
