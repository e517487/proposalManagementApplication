/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix-update.component';
import { Record10AanvraagGegevensAlgemeenMySuffixService } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix.service';
import { Record10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeenMySuffix Management Update Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent>;
        let service: Record10AanvraagGegevensAlgemeenMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent]
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record10AanvraagGegevensAlgemeenMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record10AanvraagGegevensAlgemeenMySuffix(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record10AanvraagGegevensAlgemeen = entity;
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
                    const entity = new Record10AanvraagGegevensAlgemeenMySuffix();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record10AanvraagGegevensAlgemeen = entity;
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
