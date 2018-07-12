/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindComponent } from 'app/entities/record-99-eind/record-99-eind.component';
import { Record99EindService } from 'app/entities/record-99-eind/record-99-eind.service';
import { Record99Eind } from 'app/shared/model/record-99-eind.model';

describe('Component Tests', () => {
    describe('Record99Eind Management Component', () => {
        let comp: Record99EindComponent;
        let fixture: ComponentFixture<Record99EindComponent>;
        let service: Record99EindService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindComponent],
                providers: []
            })
                .overrideTemplate(Record99EindComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record99EindComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EindService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record99Eind(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record99Einds[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
