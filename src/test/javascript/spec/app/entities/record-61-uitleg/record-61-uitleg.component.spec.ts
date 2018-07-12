/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegComponent } from 'app/entities/record-61-uitleg/record-61-uitleg.component';
import { Record61UitlegService } from 'app/entities/record-61-uitleg/record-61-uitleg.service';
import { Record61Uitleg } from 'app/shared/model/record-61-uitleg.model';

describe('Component Tests', () => {
    describe('Record61Uitleg Management Component', () => {
        let comp: Record61UitlegComponent;
        let fixture: ComponentFixture<Record61UitlegComponent>;
        let service: Record61UitlegService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegComponent],
                providers: []
            })
                .overrideTemplate(Record61UitlegComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record61UitlegComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record61UitlegService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record61Uitleg(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record61Uitlegs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
