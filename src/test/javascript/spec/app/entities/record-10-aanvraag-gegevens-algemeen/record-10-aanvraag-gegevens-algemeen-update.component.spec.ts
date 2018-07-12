/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenUpdateComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen-update.component';
import { Record10AanvraagGegevensAlgemeenService } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen.service';
import { Record10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeen Management Update Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenUpdateComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenUpdateComponent>;
        let service: Record10AanvraagGegevensAlgemeenService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenUpdateComponent]
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record10AanvraagGegevensAlgemeenService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record10AanvraagGegevensAlgemeen(123);
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
                    const entity = new Record10AanvraagGegevensAlgemeen();
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
