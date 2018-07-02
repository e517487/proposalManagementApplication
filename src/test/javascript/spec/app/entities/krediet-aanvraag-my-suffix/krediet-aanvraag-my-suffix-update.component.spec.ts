/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { KredietAanvraagMySuffixUpdateComponent } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix-update.component';
import { KredietAanvraagMySuffixService } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix.service';
import { KredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';

describe('Component Tests', () => {
    describe('KredietAanvraagMySuffix Management Update Component', () => {
        let comp: KredietAanvraagMySuffixUpdateComponent;
        let fixture: ComponentFixture<KredietAanvraagMySuffixUpdateComponent>;
        let service: KredietAanvraagMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [KredietAanvraagMySuffixUpdateComponent]
            })
                .overrideTemplate(KredietAanvraagMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(KredietAanvraagMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(KredietAanvraagMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new KredietAanvraagMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.kredietAanvraag = entity;
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
                    const entity = new KredietAanvraagMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.kredietAanvraag = entity;
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
