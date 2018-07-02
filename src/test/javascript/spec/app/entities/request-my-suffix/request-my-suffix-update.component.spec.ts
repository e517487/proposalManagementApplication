/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RequestMySuffixUpdateComponent } from 'app/entities/request-my-suffix/request-my-suffix-update.component';
import { RequestMySuffixService } from 'app/entities/request-my-suffix/request-my-suffix.service';
import { RequestMySuffix } from 'app/shared/model/request-my-suffix.model';

describe('Component Tests', () => {
    describe('RequestMySuffix Management Update Component', () => {
        let comp: RequestMySuffixUpdateComponent;
        let fixture: ComponentFixture<RequestMySuffixUpdateComponent>;
        let service: RequestMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RequestMySuffixUpdateComponent]
            })
                .overrideTemplate(RequestMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RequestMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RequestMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new RequestMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.request = entity;
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
                    const entity = new RequestMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.request = entity;
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
