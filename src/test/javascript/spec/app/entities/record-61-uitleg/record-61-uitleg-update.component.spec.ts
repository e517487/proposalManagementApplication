/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegUpdateComponent } from 'app/entities/record-61-uitleg/record-61-uitleg-update.component';
import { Record61UitlegService } from 'app/entities/record-61-uitleg/record-61-uitleg.service';
import { Record61Uitleg } from 'app/shared/model/record-61-uitleg.model';

describe('Component Tests', () => {
    describe('Record61Uitleg Management Update Component', () => {
        let comp: Record61UitlegUpdateComponent;
        let fixture: ComponentFixture<Record61UitlegUpdateComponent>;
        let service: Record61UitlegService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegUpdateComponent]
            })
                .overrideTemplate(Record61UitlegUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record61UitlegUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record61UitlegService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record61Uitleg(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record61Uitleg = entity;
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
                    const entity = new Record61Uitleg();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record61Uitleg = entity;
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
