/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegMySuffixUpdateComponent } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix-update.component';
import { Record63UitlegMySuffixService } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix.service';
import { Record63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record63UitlegMySuffix Management Update Component', () => {
        let comp: Record63UitlegMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record63UitlegMySuffixUpdateComponent>;
        let service: Record63UitlegMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegMySuffixUpdateComponent]
            })
                .overrideTemplate(Record63UitlegMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record63UitlegMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record63UitlegMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record63UitlegMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record63Uitleg = entity;
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
                    const entity = new Record63UitlegMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record63Uitleg = entity;
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
