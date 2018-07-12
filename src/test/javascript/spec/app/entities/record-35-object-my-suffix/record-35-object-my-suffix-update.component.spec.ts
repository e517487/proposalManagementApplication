/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectMySuffixUpdateComponent } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix-update.component';
import { Record35ObjectMySuffixService } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix.service';
import { Record35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';

describe('Component Tests', () => {
    describe('Record35ObjectMySuffix Management Update Component', () => {
        let comp: Record35ObjectMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record35ObjectMySuffixUpdateComponent>;
        let service: Record35ObjectMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectMySuffixUpdateComponent]
            })
                .overrideTemplate(Record35ObjectMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record35ObjectMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record35ObjectMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record35ObjectMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record35Object = entity;
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
                    const entity = new Record35ObjectMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record35Object = entity;
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
