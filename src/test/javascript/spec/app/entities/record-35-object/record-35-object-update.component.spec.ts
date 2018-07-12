/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectUpdateComponent } from 'app/entities/record-35-object/record-35-object-update.component';
import { Record35ObjectService } from 'app/entities/record-35-object/record-35-object.service';
import { Record35Object } from 'app/shared/model/record-35-object.model';

describe('Component Tests', () => {
    describe('Record35Object Management Update Component', () => {
        let comp: Record35ObjectUpdateComponent;
        let fixture: ComponentFixture<Record35ObjectUpdateComponent>;
        let service: Record35ObjectService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectUpdateComponent]
            })
                .overrideTemplate(Record35ObjectUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record35ObjectUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record35ObjectService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record35Object(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record35Object = entity;
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
                    const entity = new Record35Object();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record35Object = entity;
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
