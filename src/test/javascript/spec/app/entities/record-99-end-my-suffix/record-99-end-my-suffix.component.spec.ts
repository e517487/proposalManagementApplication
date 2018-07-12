/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EndMySuffixComponent } from 'app/entities/record-99-end-my-suffix/record-99-end-my-suffix.component';
import { Record99EndMySuffixService } from 'app/entities/record-99-end-my-suffix/record-99-end-my-suffix.service';
import { Record99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';

describe('Component Tests', () => {
    describe('Record99EndMySuffix Management Component', () => {
        let comp: Record99EndMySuffixComponent;
        let fixture: ComponentFixture<Record99EndMySuffixComponent>;
        let service: Record99EndMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EndMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record99EndMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record99EndMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EndMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record99EndMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record99Ends[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
