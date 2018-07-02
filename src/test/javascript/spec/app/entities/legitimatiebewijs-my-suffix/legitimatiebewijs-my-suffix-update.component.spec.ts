/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { LegitimatiebewijsMySuffixUpdateComponent } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix-update.component';
import { LegitimatiebewijsMySuffixService } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix.service';
import { LegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';

describe('Component Tests', () => {
    describe('LegitimatiebewijsMySuffix Management Update Component', () => {
        let comp: LegitimatiebewijsMySuffixUpdateComponent;
        let fixture: ComponentFixture<LegitimatiebewijsMySuffixUpdateComponent>;
        let service: LegitimatiebewijsMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [LegitimatiebewijsMySuffixUpdateComponent]
            })
                .overrideTemplate(LegitimatiebewijsMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(LegitimatiebewijsMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(LegitimatiebewijsMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new LegitimatiebewijsMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.legitimatiebewijs = entity;
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
                    const entity = new LegitimatiebewijsMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.legitimatiebewijs = entity;
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
