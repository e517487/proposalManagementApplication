/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenMySuffixComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix.component';
import { Record10AanvraagGegevensAlgemeenMySuffixService } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix.service';
import { Record10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeenMySuffix Management Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenMySuffixComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenMySuffixComponent>;
        let service: Record10AanvraagGegevensAlgemeenMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record10AanvraagGegevensAlgemeenMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record10AanvraagGegevensAlgemeenMySuffix(123)],
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
