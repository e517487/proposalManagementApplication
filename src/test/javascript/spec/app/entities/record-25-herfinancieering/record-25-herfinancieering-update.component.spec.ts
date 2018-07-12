/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringUpdateComponent } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering-update.component';
import { Record25HerfinancieeringService } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering.service';
import { Record25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';

describe('Component Tests', () => {
    describe('Record25Herfinancieering Management Update Component', () => {
        let comp: Record25HerfinancieeringUpdateComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringUpdateComponent>;
        let service: Record25HerfinancieeringService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringUpdateComponent]
            })
                .overrideTemplate(Record25HerfinancieeringUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record25HerfinancieeringUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record25HerfinancieeringService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record25Herfinancieering(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record25Herfinancieering = entity;
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
                    const entity = new Record25Herfinancieering();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record25Herfinancieering = entity;
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
