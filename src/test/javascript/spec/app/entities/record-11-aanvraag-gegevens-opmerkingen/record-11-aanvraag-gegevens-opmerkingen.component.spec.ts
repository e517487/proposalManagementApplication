/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen.component';
import { Record11AanvraagGegevensOpmerkingenService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen.service';
import { Record11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingen Management Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenComponent>;
        let service: Record11AanvraagGegevensOpmerkingenService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenComponent],
                providers: []
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record11AanvraagGegevensOpmerkingenService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record11AanvraagGegevensOpmerkingen(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record11AanvraagGegevensOpmerkingens[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
