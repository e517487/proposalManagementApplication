/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { VrijeTekstMySuffixDetailComponent } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix-detail.component';
import { VrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';

describe('Component Tests', () => {
    describe('VrijeTekstMySuffix Management Detail Component', () => {
        let comp: VrijeTekstMySuffixDetailComponent;
        let fixture: ComponentFixture<VrijeTekstMySuffixDetailComponent>;
        const route = ({ data: of({ vrijeTekst: new VrijeTekstMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [VrijeTekstMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(VrijeTekstMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(VrijeTekstMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.vrijeTekst).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
