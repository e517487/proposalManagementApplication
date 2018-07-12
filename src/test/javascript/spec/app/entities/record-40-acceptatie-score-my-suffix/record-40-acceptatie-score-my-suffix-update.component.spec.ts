/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreMySuffixUpdateComponent } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix-update.component';
import { Record40AcceptatieScoreMySuffixService } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix.service';
import { Record40AcceptatieScoreMySuffix } from 'app/shared/model/record-40-acceptatie-score-my-suffix.model';

describe('Component Tests', () => {
    describe('Record40AcceptatieScoreMySuffix Management Update Component', () => {
        let comp: Record40AcceptatieScoreMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreMySuffixUpdateComponent>;
        let service: Record40AcceptatieScoreMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreMySuffixUpdateComponent]
            })
                .overrideTemplate(Record40AcceptatieScoreMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record40AcceptatieScoreMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record40AcceptatieScoreMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record40AcceptatieScoreMySuffix(123);
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
                    const entity = new Record40AcceptatieScoreMySuffix();
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
