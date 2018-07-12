/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindUpdateComponent } from 'app/entities/record-99-eind/record-99-eind-update.component';
import { Record99EindService } from 'app/entities/record-99-eind/record-99-eind.service';
import { Record99Eind } from 'app/shared/model/record-99-eind.model';

describe('Component Tests', () => {
    describe('Record99Eind Management Update Component', () => {
        let comp: Record99EindUpdateComponent;
        let fixture: ComponentFixture<Record99EindUpdateComponent>;
        let service: Record99EindService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindUpdateComponent]
            })
                .overrideTemplate(Record99EindUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record99EindUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EindService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record99Eind(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record99Eind = entity;
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
                    const entity = new Record99Eind();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record99Eind = entity;
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
