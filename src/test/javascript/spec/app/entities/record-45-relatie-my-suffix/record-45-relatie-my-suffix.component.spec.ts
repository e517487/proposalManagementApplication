/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieMySuffixComponent } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix.component';
import { Record45RelatieMySuffixService } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix.service';
import { Record45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';

describe('Component Tests', () => {
    describe('Record45RelatieMySuffix Management Component', () => {
        let comp: Record45RelatieMySuffixComponent;
        let fixture: ComponentFixture<Record45RelatieMySuffixComponent>;
        let service: Record45RelatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record45RelatieMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record45RelatieMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record45RelatieMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record45RelatieMySuffix(123)],
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
