/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegUpdateComponent } from 'app/entities/record-62-uitleg/record-62-uitleg-update.component';
import { Record62UitlegService } from 'app/entities/record-62-uitleg/record-62-uitleg.service';
import { Record62Uitleg } from 'app/shared/model/record-62-uitleg.model';

describe('Component Tests', () => {
    describe('Record62Uitleg Management Update Component', () => {
        let comp: Record62UitlegUpdateComponent;
        let fixture: ComponentFixture<Record62UitlegUpdateComponent>;
        let service: Record62UitlegService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegUpdateComponent]
            })
                .overrideTemplate(Record62UitlegUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record62UitlegUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record62UitlegService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record62Uitleg(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record62Uitleg = entity;
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
                    const entity = new Record62Uitleg();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record62Uitleg = entity;
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
