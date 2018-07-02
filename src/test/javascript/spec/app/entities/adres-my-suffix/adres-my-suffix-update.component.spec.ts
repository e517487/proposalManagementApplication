/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AdresMySuffixUpdateComponent } from 'app/entities/adres-my-suffix/adres-my-suffix-update.component';
import { AdresMySuffixService } from 'app/entities/adres-my-suffix/adres-my-suffix.service';
import { AdresMySuffix } from 'app/shared/model/adres-my-suffix.model';

describe('Component Tests', () => {
    describe('AdresMySuffix Management Update Component', () => {
        let comp: AdresMySuffixUpdateComponent;
        let fixture: ComponentFixture<AdresMySuffixUpdateComponent>;
        let service: AdresMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AdresMySuffixUpdateComponent]
            })
                .overrideTemplate(AdresMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AdresMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AdresMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AdresMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.adres = entity;
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
                    const entity = new AdresMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.adres = entity;
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
