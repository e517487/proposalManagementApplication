/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AlgemeenMySuffixDetailComponent } from 'app/entities/algemeen-my-suffix/algemeen-my-suffix-detail.component';
import { AlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';

describe('Component Tests', () => {
    describe('AlgemeenMySuffix Management Detail Component', () => {
        let comp: AlgemeenMySuffixDetailComponent;
        let fixture: ComponentFixture<AlgemeenMySuffixDetailComponent>;
        const route = ({ data: of({ algemeen: new AlgemeenMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AlgemeenMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AlgemeenMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AlgemeenMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.algemeen).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
