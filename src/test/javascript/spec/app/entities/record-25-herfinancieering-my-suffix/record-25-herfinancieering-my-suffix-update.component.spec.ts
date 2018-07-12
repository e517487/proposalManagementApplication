/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringMySuffixUpdateComponent } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix-update.component';
import { Record25HerfinancieeringMySuffixService } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix.service';
import { Record25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';

describe('Component Tests', () => {
    describe('Record25HerfinancieeringMySuffix Management Update Component', () => {
        let comp: Record25HerfinancieeringMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringMySuffixUpdateComponent>;
        let service: Record25HerfinancieeringMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringMySuffixUpdateComponent]
            })
                .overrideTemplate(Record25HerfinancieeringMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record25HerfinancieeringMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record25HerfinancieeringMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record25HerfinancieeringMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record25Herfinancieering = entity;
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
                    const entity = new Record25HerfinancieeringMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record25Herfinancieering = entity;
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
