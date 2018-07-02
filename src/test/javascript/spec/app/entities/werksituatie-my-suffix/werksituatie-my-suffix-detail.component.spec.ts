/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { WerksituatieMySuffixDetailComponent } from 'app/entities/werksituatie-my-suffix/werksituatie-my-suffix-detail.component';
import { WerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';

describe('Component Tests', () => {
    describe('WerksituatieMySuffix Management Detail Component', () => {
        let comp: WerksituatieMySuffixDetailComponent;
        let fixture: ComponentFixture<WerksituatieMySuffixDetailComponent>;
        const route = ({ data: of({ werksituatie: new WerksituatieMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [WerksituatieMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(WerksituatieMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(WerksituatieMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.werksituatie).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
