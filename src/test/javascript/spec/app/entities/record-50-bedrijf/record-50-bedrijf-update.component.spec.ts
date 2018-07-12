/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfUpdateComponent } from 'app/entities/record-50-bedrijf/record-50-bedrijf-update.component';
import { Record50BedrijfService } from 'app/entities/record-50-bedrijf/record-50-bedrijf.service';
import { Record50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';

describe('Component Tests', () => {
    describe('Record50Bedrijf Management Update Component', () => {
        let comp: Record50BedrijfUpdateComponent;
        let fixture: ComponentFixture<Record50BedrijfUpdateComponent>;
        let service: Record50BedrijfService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfUpdateComponent]
            })
                .overrideTemplate(Record50BedrijfUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record50BedrijfUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record50BedrijfService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record50Bedrijf(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record50Bedrijf = entity;
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
                    const entity = new Record50Bedrijf();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record50Bedrijf = entity;
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
