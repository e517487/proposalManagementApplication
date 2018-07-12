/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegMySuffixUpdateComponent } from 'app/entities/record-61-uitleg-my-suffix/record-61-uitleg-my-suffix-update.component';
import { Record61UitlegMySuffixService } from 'app/entities/record-61-uitleg-my-suffix/record-61-uitleg-my-suffix.service';
import { Record61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record61UitlegMySuffix Management Update Component', () => {
        let comp: Record61UitlegMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record61UitlegMySuffixUpdateComponent>;
        let service: Record61UitlegMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegMySuffixUpdateComponent]
            })
                .overrideTemplate(Record61UitlegMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record61UitlegMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record61UitlegMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record61UitlegMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record61Uitleg = entity;
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
                    const entity = new Record61UitlegMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record61Uitleg = entity;
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
