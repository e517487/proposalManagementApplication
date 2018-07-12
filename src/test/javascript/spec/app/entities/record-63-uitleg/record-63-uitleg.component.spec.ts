/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegComponent } from 'app/entities/record-63-uitleg/record-63-uitleg.component';
import { Record63UitlegService } from 'app/entities/record-63-uitleg/record-63-uitleg.service';
import { Record63Uitleg } from 'app/shared/model/record-63-uitleg.model';

describe('Component Tests', () => {
    describe('Record63Uitleg Management Component', () => {
        let comp: Record63UitlegComponent;
        let fixture: ComponentFixture<Record63UitlegComponent>;
        let service: Record63UitlegService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegComponent],
                providers: []
            })
                .overrideTemplate(Record63UitlegComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record63UitlegComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record63UitlegService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record63Uitleg(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record63Uitlegs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
