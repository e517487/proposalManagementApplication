/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieMySuffixUpdateComponent } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix-update.component';
import { Record45RelatieMySuffixService } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix.service';
import { Record45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';

describe('Component Tests', () => {
    describe('Record45RelatieMySuffix Management Update Component', () => {
        let comp: Record45RelatieMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record45RelatieMySuffixUpdateComponent>;
        let service: Record45RelatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieMySuffixUpdateComponent]
            })
                .overrideTemplate(Record45RelatieMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record45RelatieMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record45RelatieMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record45RelatieMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record45Relatie = entity;
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
                    const entity = new Record45RelatieMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record45Relatie = entity;
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
