/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringMySuffixComponent } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix.component';
import { Record55ScoringMySuffixService } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix.service';
import { Record55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';

describe('Component Tests', () => {
    describe('Record55ScoringMySuffix Management Component', () => {
        let comp: Record55ScoringMySuffixComponent;
        let fixture: ComponentFixture<Record55ScoringMySuffixComponent>;
        let service: Record55ScoringMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record55ScoringMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record55ScoringMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record55ScoringMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record55ScoringMySuffix(123)],
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
