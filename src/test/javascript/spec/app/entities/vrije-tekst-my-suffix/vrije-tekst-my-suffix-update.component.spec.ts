/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { VrijeTekstMySuffixUpdateComponent } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix-update.component';
import { VrijeTekstMySuffixService } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix.service';
import { VrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';

describe('Component Tests', () => {
    describe('VrijeTekstMySuffix Management Update Component', () => {
        let comp: VrijeTekstMySuffixUpdateComponent;
        let fixture: ComponentFixture<VrijeTekstMySuffixUpdateComponent>;
        let service: VrijeTekstMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [VrijeTekstMySuffixUpdateComponent]
            })
                .overrideTemplate(VrijeTekstMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(VrijeTekstMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VrijeTekstMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new VrijeTekstMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.vrijeTekst = entity;
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
                    const entity = new VrijeTekstMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.vrijeTekst = entity;
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
