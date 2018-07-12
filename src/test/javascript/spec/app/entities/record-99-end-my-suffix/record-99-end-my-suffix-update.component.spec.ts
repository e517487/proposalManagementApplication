/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EndMySuffixUpdateComponent } from 'app/entities/record-99-end-my-suffix/record-99-end-my-suffix-update.component';
import { Record99EndMySuffixService } from 'app/entities/record-99-end-my-suffix/record-99-end-my-suffix.service';
import { Record99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';

describe('Component Tests', () => {
    describe('Record99EndMySuffix Management Update Component', () => {
        let comp: Record99EndMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record99EndMySuffixUpdateComponent>;
        let service: Record99EndMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EndMySuffixUpdateComponent]
            })
                .overrideTemplate(Record99EndMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record99EndMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EndMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record99EndMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record99End = entity;
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
                    const entity = new Record99EndMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record99End = entity;
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
