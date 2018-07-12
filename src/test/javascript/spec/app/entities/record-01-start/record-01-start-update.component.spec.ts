/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record01StartUpdateComponent } from 'app/entities/record-01-start/record-01-start-update.component';
import { Record01StartService } from 'app/entities/record-01-start/record-01-start.service';
import { Record01Start } from 'app/shared/model/record-01-start.model';

describe('Component Tests', () => {
    describe('Record01Start Management Update Component', () => {
        let comp: Record01StartUpdateComponent;
        let fixture: ComponentFixture<Record01StartUpdateComponent>;
        let service: Record01StartService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record01StartUpdateComponent]
            })
                .overrideTemplate(Record01StartUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record01StartUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record01StartService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record01Start(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record01Start = entity;
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
                    const entity = new Record01Start();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record01Start = entity;
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
