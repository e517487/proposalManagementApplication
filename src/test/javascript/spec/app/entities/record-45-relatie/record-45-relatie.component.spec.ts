/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieComponent } from 'app/entities/record-45-relatie/record-45-relatie.component';
import { Record45RelatieService } from 'app/entities/record-45-relatie/record-45-relatie.service';
import { Record45Relatie } from 'app/shared/model/record-45-relatie.model';

describe('Component Tests', () => {
    describe('Record45Relatie Management Component', () => {
        let comp: Record45RelatieComponent;
        let fixture: ComponentFixture<Record45RelatieComponent>;
        let service: Record45RelatieService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieComponent],
                providers: []
            })
                .overrideTemplate(Record45RelatieComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record45RelatieComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record45RelatieService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record45Relatie(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record45Relaties[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
