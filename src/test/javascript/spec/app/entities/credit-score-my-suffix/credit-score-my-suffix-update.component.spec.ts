/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { CreditScoreMySuffixUpdateComponent } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix-update.component';
import { CreditScoreMySuffixService } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix.service';
import { CreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';

describe('Component Tests', () => {
    describe('CreditScoreMySuffix Management Update Component', () => {
        let comp: CreditScoreMySuffixUpdateComponent;
        let fixture: ComponentFixture<CreditScoreMySuffixUpdateComponent>;
        let service: CreditScoreMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [CreditScoreMySuffixUpdateComponent]
            })
                .overrideTemplate(CreditScoreMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(CreditScoreMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CreditScoreMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new CreditScoreMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.creditScore = entity;
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
                    const entity = new CreditScoreMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.creditScore = entity;
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
