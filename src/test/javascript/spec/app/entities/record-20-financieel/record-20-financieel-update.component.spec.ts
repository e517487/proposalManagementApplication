/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelUpdateComponent } from 'app/entities/record-20-financieel/record-20-financieel-update.component';
import { Record20FinancieelService } from 'app/entities/record-20-financieel/record-20-financieel.service';
import { Record20Financieel } from 'app/shared/model/record-20-financieel.model';

describe('Component Tests', () => {
    describe('Record20Financieel Management Update Component', () => {
        let comp: Record20FinancieelUpdateComponent;
        let fixture: ComponentFixture<Record20FinancieelUpdateComponent>;
        let service: Record20FinancieelService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelUpdateComponent]
            })
                .overrideTemplate(Record20FinancieelUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record20FinancieelUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record20FinancieelService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record20Financieel(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record20Financieel = entity;
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
                    const entity = new Record20Financieel();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record20Financieel = entity;
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
