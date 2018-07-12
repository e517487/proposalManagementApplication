/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegUpdateComponent } from 'app/entities/record-63-uitleg/record-63-uitleg-update.component';
import { Record63UitlegService } from 'app/entities/record-63-uitleg/record-63-uitleg.service';
import { Record63Uitleg } from 'app/shared/model/record-63-uitleg.model';

describe('Component Tests', () => {
    describe('Record63Uitleg Management Update Component', () => {
        let comp: Record63UitlegUpdateComponent;
        let fixture: ComponentFixture<Record63UitlegUpdateComponent>;
        let service: Record63UitlegService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegUpdateComponent]
            })
                .overrideTemplate(Record63UitlegUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record63UitlegUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record63UitlegService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record63Uitleg(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record63Uitleg = entity;
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
                    const entity = new Record63Uitleg();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record63Uitleg = entity;
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
