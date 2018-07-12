/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindMySuffixUpdateComponent } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix-update.component';
import { Record99EindMySuffixService } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix.service';
import { Record99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';

describe('Component Tests', () => {
    describe('Record99EindMySuffix Management Update Component', () => {
        let comp: Record99EindMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record99EindMySuffixUpdateComponent>;
        let service: Record99EindMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindMySuffixUpdateComponent]
            })
                .overrideTemplate(Record99EindMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record99EindMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EindMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record99EindMySuffix(123);
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
                    const entity = new Record99EindMySuffix();
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
