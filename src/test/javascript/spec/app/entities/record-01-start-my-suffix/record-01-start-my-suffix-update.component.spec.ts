/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record01StartMySuffixUpdateComponent } from 'app/entities/record-01-start-my-suffix/record-01-start-my-suffix-update.component';
import { Record01StartMySuffixService } from 'app/entities/record-01-start-my-suffix/record-01-start-my-suffix.service';
import { Record01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';

describe('Component Tests', () => {
    describe('Record01StartMySuffix Management Update Component', () => {
        let comp: Record01StartMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record01StartMySuffixUpdateComponent>;
        let service: Record01StartMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record01StartMySuffixUpdateComponent]
            })
                .overrideTemplate(Record01StartMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record01StartMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record01StartMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record01StartMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record01Start = entity;
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
                    const entity = new Record01StartMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record01Start = entity;
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
