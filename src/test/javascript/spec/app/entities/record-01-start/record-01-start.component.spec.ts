/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record01StartComponent } from 'app/entities/record-01-start/record-01-start.component';
import { Record01StartService } from 'app/entities/record-01-start/record-01-start.service';
import { Record01Start } from 'app/shared/model/record-01-start.model';

describe('Component Tests', () => {
    describe('Record01Start Management Component', () => {
        let comp: Record01StartComponent;
        let fixture: ComponentFixture<Record01StartComponent>;
        let service: Record01StartService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record01StartComponent],
                providers: []
            })
                .overrideTemplate(Record01StartComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record01StartComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record01StartService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record01Start(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record01Starts[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
