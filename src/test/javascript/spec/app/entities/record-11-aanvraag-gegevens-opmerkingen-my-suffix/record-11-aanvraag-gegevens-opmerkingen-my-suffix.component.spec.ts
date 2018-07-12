/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenMySuffixComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix.component';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';
import { Record11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingenMySuffix Management Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenMySuffixComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenMySuffixComponent>;
        let service: Record11AanvraagGegevensOpmerkingenMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record11AanvraagGegevensOpmerkingenMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record11AanvraagGegevensOpmerkingenMySuffix(123)],
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
