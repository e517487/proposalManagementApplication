/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { KredietAanvraagMySuffixDetailComponent } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix-detail.component';
import { KredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';

describe('Component Tests', () => {
    describe('KredietAanvraagMySuffix Management Detail Component', () => {
        let comp: KredietAanvraagMySuffixDetailComponent;
        let fixture: ComponentFixture<KredietAanvraagMySuffixDetailComponent>;
        const route = ({ data: of({ kredietAanvraag: new KredietAanvraagMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [KredietAanvraagMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(KredietAanvraagMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(KredietAanvraagMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.kredietAanvraag).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
