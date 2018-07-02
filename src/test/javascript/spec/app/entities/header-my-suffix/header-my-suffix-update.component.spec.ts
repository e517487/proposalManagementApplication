/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { HeaderMySuffixUpdateComponent } from 'app/entities/header-my-suffix/header-my-suffix-update.component';
import { HeaderMySuffixService } from 'app/entities/header-my-suffix/header-my-suffix.service';
import { HeaderMySuffix } from 'app/shared/model/header-my-suffix.model';

describe('Component Tests', () => {
    describe('HeaderMySuffix Management Update Component', () => {
        let comp: HeaderMySuffixUpdateComponent;
        let fixture: ComponentFixture<HeaderMySuffixUpdateComponent>;
        let service: HeaderMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [HeaderMySuffixUpdateComponent]
            })
                .overrideTemplate(HeaderMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(HeaderMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(HeaderMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new HeaderMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.header = entity;
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
                    const entity = new HeaderMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.header = entity;
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
