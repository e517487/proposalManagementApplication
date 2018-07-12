/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenUpdateComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen-update.component';
import { Record11AanvraagGegevensOpmerkingenService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen.service';
import { Record11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingen Management Update Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenUpdateComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenUpdateComponent>;
        let service: Record11AanvraagGegevensOpmerkingenService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenUpdateComponent]
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record11AanvraagGegevensOpmerkingenService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record11AanvraagGegevensOpmerkingen(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record11AanvraagGegevensOpmerkingen = entity;
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
                    const entity = new Record11AanvraagGegevensOpmerkingen();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.record11AanvraagGegevensOpmerkingen = entity;
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
