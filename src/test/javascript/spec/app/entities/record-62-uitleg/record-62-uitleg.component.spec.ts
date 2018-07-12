/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegComponent } from 'app/entities/record-62-uitleg/record-62-uitleg.component';
import { Record62UitlegService } from 'app/entities/record-62-uitleg/record-62-uitleg.service';
import { Record62Uitleg } from 'app/shared/model/record-62-uitleg.model';

describe('Component Tests', () => {
    describe('Record62Uitleg Management Component', () => {
        let comp: Record62UitlegComponent;
        let fixture: ComponentFixture<Record62UitlegComponent>;
        let service: Record62UitlegService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegComponent],
                providers: []
            })
                .overrideTemplate(Record62UitlegComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record62UitlegComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record62UitlegService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record62Uitleg(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record62Uitlegs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
