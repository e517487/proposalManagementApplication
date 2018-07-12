/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen.component';
import { Record10AanvraagGegevensAlgemeenService } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen.service';
import { Record10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeen Management Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenComponent>;
        let service: Record10AanvraagGegevensAlgemeenService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenComponent],
                providers: []
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record10AanvraagGegevensAlgemeenService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record10AanvraagGegevensAlgemeen(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record10AanvraagGegevensAlgemeens[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
