/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilComponent } from 'app/entities/record-30-inruil/record-30-inruil.component';
import { Record30InruilService } from 'app/entities/record-30-inruil/record-30-inruil.service';
import { Record30Inruil } from 'app/shared/model/record-30-inruil.model';

describe('Component Tests', () => {
    describe('Record30Inruil Management Component', () => {
        let comp: Record30InruilComponent;
        let fixture: ComponentFixture<Record30InruilComponent>;
        let service: Record30InruilService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilComponent],
                providers: []
            })
                .overrideTemplate(Record30InruilComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record30InruilComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record30InruilService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record30Inruil(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record30Inruils[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
