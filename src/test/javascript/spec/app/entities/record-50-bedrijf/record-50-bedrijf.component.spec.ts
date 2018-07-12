/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfComponent } from 'app/entities/record-50-bedrijf/record-50-bedrijf.component';
import { Record50BedrijfService } from 'app/entities/record-50-bedrijf/record-50-bedrijf.service';
import { Record50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';

describe('Component Tests', () => {
    describe('Record50Bedrijf Management Component', () => {
        let comp: Record50BedrijfComponent;
        let fixture: ComponentFixture<Record50BedrijfComponent>;
        let service: Record50BedrijfService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfComponent],
                providers: []
            })
                .overrideTemplate(Record50BedrijfComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record50BedrijfComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record50BedrijfService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record50Bedrijf(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record50Bedrijfs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
