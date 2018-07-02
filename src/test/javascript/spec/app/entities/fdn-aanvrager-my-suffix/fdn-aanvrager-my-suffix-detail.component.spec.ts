/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FdnAanvragerMySuffixDetailComponent } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix-detail.component';
import { FdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';

describe('Component Tests', () => {
    describe('FdnAanvragerMySuffix Management Detail Component', () => {
        let comp: FdnAanvragerMySuffixDetailComponent;
        let fixture: ComponentFixture<FdnAanvragerMySuffixDetailComponent>;
        const route = ({ data: of({ fdnAanvrager: new FdnAanvragerMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FdnAanvragerMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(FdnAanvragerMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FdnAanvragerMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.fdnAanvrager).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
