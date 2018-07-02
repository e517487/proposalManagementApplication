/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AlgemeenMySuffixUpdateComponent } from 'app/entities/algemeen-my-suffix/algemeen-my-suffix-update.component';
import { AlgemeenMySuffixService } from 'app/entities/algemeen-my-suffix/algemeen-my-suffix.service';
import { AlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';

describe('Component Tests', () => {
    describe('AlgemeenMySuffix Management Update Component', () => {
        let comp: AlgemeenMySuffixUpdateComponent;
        let fixture: ComponentFixture<AlgemeenMySuffixUpdateComponent>;
        let service: AlgemeenMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AlgemeenMySuffixUpdateComponent]
            })
                .overrideTemplate(AlgemeenMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AlgemeenMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AlgemeenMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AlgemeenMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.algemeen = entity;
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
                    const entity = new AlgemeenMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.algemeen = entity;
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
