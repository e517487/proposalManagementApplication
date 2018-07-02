/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FinancieleSituatieMySuffixUpdateComponent } from 'app/entities/financiele-situatie-my-suffix/financiele-situatie-my-suffix-update.component';
import { FinancieleSituatieMySuffixService } from 'app/entities/financiele-situatie-my-suffix/financiele-situatie-my-suffix.service';
import { FinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';

describe('Component Tests', () => {
    describe('FinancieleSituatieMySuffix Management Update Component', () => {
        let comp: FinancieleSituatieMySuffixUpdateComponent;
        let fixture: ComponentFixture<FinancieleSituatieMySuffixUpdateComponent>;
        let service: FinancieleSituatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FinancieleSituatieMySuffixUpdateComponent]
            })
                .overrideTemplate(FinancieleSituatieMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(FinancieleSituatieMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FinancieleSituatieMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new FinancieleSituatieMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.financieleSituatie = entity;
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
                    const entity = new FinancieleSituatieMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.financieleSituatie = entity;
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
