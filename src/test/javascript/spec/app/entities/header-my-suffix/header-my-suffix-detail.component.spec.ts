/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { HeaderMySuffixDetailComponent } from 'app/entities/header-my-suffix/header-my-suffix-detail.component';
import { HeaderMySuffix } from 'app/shared/model/header-my-suffix.model';

describe('Component Tests', () => {
    describe('HeaderMySuffix Management Detail Component', () => {
        let comp: HeaderMySuffixDetailComponent;
        let fixture: ComponentFixture<HeaderMySuffixDetailComponent>;
        const route = ({ data: of({ header: new HeaderMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [HeaderMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(HeaderMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(HeaderMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.header).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
