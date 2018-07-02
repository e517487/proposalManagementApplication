/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { HeaderMySuffixComponent } from 'app/entities/header-my-suffix/header-my-suffix.component';
import { HeaderMySuffixService } from 'app/entities/header-my-suffix/header-my-suffix.service';
import { HeaderMySuffix } from 'app/shared/model/header-my-suffix.model';

describe('Component Tests', () => {
    describe('HeaderMySuffix Management Component', () => {
        let comp: HeaderMySuffixComponent;
        let fixture: ComponentFixture<HeaderMySuffixComponent>;
        let service: HeaderMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [HeaderMySuffixComponent],
                providers: []
            })
                .overrideTemplate(HeaderMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(HeaderMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(HeaderMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new HeaderMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.headers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
