/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreUpdateComponent } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score-update.component';
import { Record40AcceptatieScoreService } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score.service';
import { Record40AcceptatieScore } from 'app/shared/model/record-40-acceptatie-score.model';

describe('Component Tests', () => {
    describe('Record40AcceptatieScore Management Update Component', () => {
        let comp: Record40AcceptatieScoreUpdateComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreUpdateComponent>;
        let service: Record40AcceptatieScoreService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreUpdateComponent]
            })
                .overrideTemplate(Record40AcceptatieScoreUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record40AcceptatieScoreUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record40AcceptatieScoreService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record40AcceptatieScore(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record40AcceptatieScore = entity;
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
                    const entity = new Record40AcceptatieScore();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record40AcceptatieScore = entity;
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
