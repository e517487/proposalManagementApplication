/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { GezinssituatieMySuffixUpdateComponent } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix-update.component';
import { GezinssituatieMySuffixService } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix.service';
import { GezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';

describe('Component Tests', () => {
    describe('GezinssituatieMySuffix Management Update Component', () => {
        let comp: GezinssituatieMySuffixUpdateComponent;
        let fixture: ComponentFixture<GezinssituatieMySuffixUpdateComponent>;
        let service: GezinssituatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [GezinssituatieMySuffixUpdateComponent]
            })
                .overrideTemplate(GezinssituatieMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(GezinssituatieMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(GezinssituatieMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new GezinssituatieMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.gezinssituatie = entity;
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
                    const entity = new GezinssituatieMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.gezinssituatie = entity;
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
