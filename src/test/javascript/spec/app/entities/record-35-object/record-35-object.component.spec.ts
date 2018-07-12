/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectComponent } from 'app/entities/record-35-object/record-35-object.component';
import { Record35ObjectService } from 'app/entities/record-35-object/record-35-object.service';
import { Record35Object } from 'app/shared/model/record-35-object.model';

describe('Component Tests', () => {
    describe('Record35Object Management Component', () => {
        let comp: Record35ObjectComponent;
        let fixture: ComponentFixture<Record35ObjectComponent>;
        let service: Record35ObjectService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectComponent],
                providers: []
            })
                .overrideTemplate(Record35ObjectComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record35ObjectComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record35ObjectService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record35Object(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record35Objects[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
