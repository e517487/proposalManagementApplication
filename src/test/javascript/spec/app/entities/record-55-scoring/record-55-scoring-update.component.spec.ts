/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringUpdateComponent } from 'app/entities/record-55-scoring/record-55-scoring-update.component';
import { Record55ScoringService } from 'app/entities/record-55-scoring/record-55-scoring.service';
import { Record55Scoring } from 'app/shared/model/record-55-scoring.model';

describe('Component Tests', () => {
    describe('Record55Scoring Management Update Component', () => {
        let comp: Record55ScoringUpdateComponent;
        let fixture: ComponentFixture<Record55ScoringUpdateComponent>;
        let service: Record55ScoringService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringUpdateComponent]
            })
                .overrideTemplate(Record55ScoringUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record55ScoringUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record55ScoringService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record55Scoring(123);
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
                    const entity = new Record55Scoring();
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
