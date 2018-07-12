/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix-update.component';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';
import { Record11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingenMySuffix Management Update Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent>;
        let service: Record11AanvraagGegevensOpmerkingenMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent]
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenMySuffixUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record11AanvraagGegevensOpmerkingenMySuffixService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Record11AanvraagGegevensOpmerkingenMySuffix(123);
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
                    const entity = new Record11AanvraagGegevensOpmerkingenMySuffix();
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
