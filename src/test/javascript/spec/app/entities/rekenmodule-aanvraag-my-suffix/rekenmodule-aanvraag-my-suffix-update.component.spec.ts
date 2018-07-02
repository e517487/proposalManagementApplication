/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RekenmoduleAanvraagMySuffixUpdateComponent } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix-update.component';
import { RekenmoduleAanvraagMySuffixService } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix.service';
import { RekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';

describe('Component Tests', () => {
    describe('RekenmoduleAanvraagMySuffix Management Update Component', () => {
        let comp: RekenmoduleAanvraagMySuffixUpdateComponent;
        let fixture: ComponentFixture<RekenmoduleAanvraagMySuffixUpdateComponent>;
        let service: RekenmoduleAanvraagMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RekenmoduleAanvraagMySuffixUpdateComponent]
            })
                .overrideTemplate(RekenmoduleAanvraagMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RekenmoduleAanvraagMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RekenmoduleAanvraagMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new RekenmoduleAanvraagMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.rekenmoduleAanvraag = entity;
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
                    const entity = new RekenmoduleAanvraagMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.rekenmoduleAanvraag = entity;
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
