/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { GezinssituatieMySuffixDetailComponent } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix-detail.component';
import { GezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';

describe('Component Tests', () => {
    describe('GezinssituatieMySuffix Management Detail Component', () => {
        let comp: GezinssituatieMySuffixDetailComponent;
        let fixture: ComponentFixture<GezinssituatieMySuffixDetailComponent>;
        const route = ({ data: of({ gezinssituatie: new GezinssituatieMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [GezinssituatieMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(GezinssituatieMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(GezinssituatieMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.gezinssituatie).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
