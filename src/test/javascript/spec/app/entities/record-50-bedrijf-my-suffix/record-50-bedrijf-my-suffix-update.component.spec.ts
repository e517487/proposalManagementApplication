/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfMySuffixUpdateComponent } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix-update.component';
import { Record50BedrijfMySuffixService } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix.service';
import { Record50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';

describe('Component Tests', () => {
    describe('Record50BedrijfMySuffix Management Update Component', () => {
        let comp: Record50BedrijfMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record50BedrijfMySuffixUpdateComponent>;
        let service: Record50BedrijfMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfMySuffixUpdateComponent]
            })
                .overrideTemplate(Record50BedrijfMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record50BedrijfMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record50BedrijfMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record50BedrijfMySuffix(123);
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
                    const entity = new Record50BedrijfMySuffix();
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
