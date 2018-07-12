/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilUpdateComponent } from 'app/entities/record-30-inruil/record-30-inruil-update.component';
import { Record30InruilService } from 'app/entities/record-30-inruil/record-30-inruil.service';
import { Record30Inruil } from 'app/shared/model/record-30-inruil.model';

describe('Component Tests', () => {
    describe('Record30Inruil Management Update Component', () => {
        let comp: Record30InruilUpdateComponent;
        let fixture: ComponentFixture<Record30InruilUpdateComponent>;
        let service: Record30InruilService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilUpdateComponent]
            })
                .overrideTemplate(Record30InruilUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record30InruilUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record30InruilService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record30Inruil(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record30Inruil = entity;
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
                    const entity = new Record30Inruil();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record30Inruil = entity;
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
