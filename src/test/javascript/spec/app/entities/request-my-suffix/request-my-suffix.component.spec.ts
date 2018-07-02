/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RequestMySuffixComponent } from 'app/entities/request-my-suffix/request-my-suffix.component';
import { RequestMySuffixService } from 'app/entities/request-my-suffix/request-my-suffix.service';
import { RequestMySuffix } from 'app/shared/model/request-my-suffix.model';

describe('Component Tests', () => {
    describe('RequestMySuffix Management Component', () => {
        let comp: RequestMySuffixComponent;
        let fixture: ComponentFixture<RequestMySuffixComponent>;
        let service: RequestMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RequestMySuffixComponent],
                providers: []
            })
                .overrideTemplate(RequestMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RequestMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RequestMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new RequestMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.requests[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
