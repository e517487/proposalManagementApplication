/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { TekstRegelMySuffixUpdateComponent } from 'app/entities/tekst-regel-my-suffix/tekst-regel-my-suffix-update.component';
import { TekstRegelMySuffixService } from 'app/entities/tekst-regel-my-suffix/tekst-regel-my-suffix.service';
import { TekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';

describe('Component Tests', () => {
    describe('TekstRegelMySuffix Management Update Component', () => {
        let comp: TekstRegelMySuffixUpdateComponent;
        let fixture: ComponentFixture<TekstRegelMySuffixUpdateComponent>;
        let service: TekstRegelMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [TekstRegelMySuffixUpdateComponent]
            })
                .overrideTemplate(TekstRegelMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(TekstRegelMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TekstRegelMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new TekstRegelMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.tekstRegel = entity;
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
                    const entity = new TekstRegelMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.tekstRegel = entity;
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
