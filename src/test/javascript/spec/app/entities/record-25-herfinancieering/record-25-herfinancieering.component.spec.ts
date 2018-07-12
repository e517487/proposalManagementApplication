/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringComponent } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering.component';
import { Record25HerfinancieeringService } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering.service';
import { Record25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';

describe('Component Tests', () => {
    describe('Record25Herfinancieering Management Component', () => {
        let comp: Record25HerfinancieeringComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringComponent>;
        let service: Record25HerfinancieeringService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringComponent],
                providers: []
            })
                .overrideTemplate(Record25HerfinancieeringComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record25HerfinancieeringComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record25HerfinancieeringService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record25Herfinancieering(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record25Herfinancieerings[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
