/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RequestMySuffixDetailComponent } from 'app/entities/request-my-suffix/request-my-suffix-detail.component';
import { RequestMySuffix } from 'app/shared/model/request-my-suffix.model';

describe('Component Tests', () => {
    describe('RequestMySuffix Management Detail Component', () => {
        let comp: RequestMySuffixDetailComponent;
        let fixture: ComponentFixture<RequestMySuffixDetailComponent>;
        const route = ({ data: of({ request: new RequestMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RequestMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(RequestMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(RequestMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.request).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
