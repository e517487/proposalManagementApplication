/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieUpdateComponent } from 'app/entities/record-45-relatie/record-45-relatie-update.component';
import { Record45RelatieService } from 'app/entities/record-45-relatie/record-45-relatie.service';
import { Record45Relatie } from 'app/shared/model/record-45-relatie.model';

describe('Component Tests', () => {
    describe('Record45Relatie Management Update Component', () => {
        let comp: Record45RelatieUpdateComponent;
        let fixture: ComponentFixture<Record45RelatieUpdateComponent>;
        let service: Record45RelatieService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieUpdateComponent]
            })
                .overrideTemplate(Record45RelatieUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record45RelatieUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record45RelatieService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record45Relatie(123);
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
                    const entity = new Record45Relatie();
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
