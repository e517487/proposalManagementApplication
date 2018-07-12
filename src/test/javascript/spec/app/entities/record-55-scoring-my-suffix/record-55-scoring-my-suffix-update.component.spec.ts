/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringMySuffixUpdateComponent } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix-update.component';
import { Record55ScoringMySuffixService } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix.service';
import { Record55ScoringMySuffix } from 'app/shared/model/record-55-scoring-my-suffix.model';

describe('Component Tests', () => {
    describe('Record55ScoringMySuffix Management Update Component', () => {
        let comp: Record55ScoringMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record55ScoringMySuffixUpdateComponent>;
        let service: Record55ScoringMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringMySuffixUpdateComponent]
            })
                .overrideTemplate(Record55ScoringMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record55ScoringMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record55ScoringMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record55ScoringMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record55Scoring = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record55ScoringMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record55Scoring = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
