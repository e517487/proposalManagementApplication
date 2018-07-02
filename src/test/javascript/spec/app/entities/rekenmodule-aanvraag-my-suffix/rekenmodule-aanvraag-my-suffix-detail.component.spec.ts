/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RekenmoduleAanvraagMySuffixDetailComponent } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix-detail.component';
import { RekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';

describe('Component Tests', () => {
    describe('RekenmoduleAanvraagMySuffix Management Detail Component', () => {
        let comp: RekenmoduleAanvraagMySuffixDetailComponent;
        let fixture: ComponentFixture<RekenmoduleAanvraagMySuffixDetailComponent>;
        const route = ({ data: of({ rekenmoduleAanvraag: new RekenmoduleAanvraagMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RekenmoduleAanvraagMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(RekenmoduleAanvraagMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(RekenmoduleAanvraagMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.rekenmoduleAanvraag).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
