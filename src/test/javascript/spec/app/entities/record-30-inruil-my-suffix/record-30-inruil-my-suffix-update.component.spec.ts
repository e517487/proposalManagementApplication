/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilMySuffixUpdateComponent } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix-update.component';
import { Record30InruilMySuffixService } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix.service';
import { Record30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';

describe('Component Tests', () => {
    describe('Record30InruilMySuffix Management Update Component', () => {
        let comp: Record30InruilMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record30InruilMySuffixUpdateComponent>;
        let service: Record30InruilMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilMySuffixUpdateComponent]
            })
                .overrideTemplate(Record30InruilMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record30InruilMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record30InruilMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record30InruilMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record30Inruil = entity;
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
                    const entity = new Record30InruilMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record30Inruil = entity;
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
