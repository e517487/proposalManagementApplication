/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelMySuffixUpdateComponent } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix-update.component';
import { Record20FinancieelMySuffixService } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix.service';
import { Record20FinancieelMySuffix } from 'app/shared/model/record-20-financieel-my-suffix.model';

describe('Component Tests', () => {
    describe('Record20FinancieelMySuffix Management Update Component', () => {
        let comp: Record20FinancieelMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record20FinancieelMySuffixUpdateComponent>;
        let service: Record20FinancieelMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelMySuffixUpdateComponent]
            })
                .overrideTemplate(Record20FinancieelMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record20FinancieelMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record20FinancieelMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record20FinancieelMySuffix(123);
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
                    const entity = new Record20FinancieelMySuffix();
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
