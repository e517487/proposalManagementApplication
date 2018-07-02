/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { TekstRegelMySuffixDetailComponent } from 'app/entities/tekst-regel-my-suffix/tekst-regel-my-suffix-detail.component';
import { TekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';

describe('Component Tests', () => {
    describe('TekstRegelMySuffix Management Detail Component', () => {
        let comp: TekstRegelMySuffixDetailComponent;
        let fixture: ComponentFixture<TekstRegelMySuffixDetailComponent>;
        const route = ({ data: of({ tekstRegel: new TekstRegelMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [TekstRegelMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(TekstRegelMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(TekstRegelMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.tekstRegel).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
