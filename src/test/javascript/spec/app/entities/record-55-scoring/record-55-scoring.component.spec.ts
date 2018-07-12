/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringComponent } from 'app/entities/record-55-scoring/record-55-scoring.component';
import { Record55ScoringService } from 'app/entities/record-55-scoring/record-55-scoring.service';
import { Record55Scoring } from 'app/shared/model/record-55-scoring.model';

describe('Component Tests', () => {
    describe('Record55Scoring Management Component', () => {
        let comp: Record55ScoringComponent;
        let fixture: ComponentFixture<Record55ScoringComponent>;
        let service: Record55ScoringService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringComponent],
                providers: []
            })
                .overrideTemplate(Record55ScoringComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record55ScoringComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record55ScoringService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record55Scoring(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record55Scorings[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
