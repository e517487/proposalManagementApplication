/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FdnAanvragerMySuffixUpdateComponent } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix-update.component';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix.service';
import { FdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';

describe('Component Tests', () => {
    describe('FdnAanvragerMySuffix Management Update Component', () => {
        let comp: FdnAanvragerMySuffixUpdateComponent;
        let fixture: ComponentFixture<FdnAanvragerMySuffixUpdateComponent>;
        let service: FdnAanvragerMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FdnAanvragerMySuffixUpdateComponent]
            })
                .overrideTemplate(FdnAanvragerMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(FdnAanvragerMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FdnAanvragerMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new FdnAanvragerMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.fdnAanvrager = entity;
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
                    const entity = new FdnAanvragerMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.fdnAanvrager = entity;
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
