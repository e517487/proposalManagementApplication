/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record01StartMySuffixComponent } from 'app/entities/record-01-start-my-suffix/record-01-start-my-suffix.component';
import { Record01StartMySuffixService } from 'app/entities/record-01-start-my-suffix/record-01-start-my-suffix.service';
import { Record01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';

describe('Component Tests', () => {
    describe('Record01StartMySuffix Management Component', () => {
        let comp: Record01StartMySuffixComponent;
        let fixture: ComponentFixture<Record01StartMySuffixComponent>;
        let service: Record01StartMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record01StartMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record01StartMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record01StartMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record01StartMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record01StartMySuffix(123)],
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
