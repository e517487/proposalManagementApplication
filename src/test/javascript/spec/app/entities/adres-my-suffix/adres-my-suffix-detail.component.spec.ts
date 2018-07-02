/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AdresMySuffixDetailComponent } from 'app/entities/adres-my-suffix/adres-my-suffix-detail.component';
import { AdresMySuffix } from 'app/shared/model/adres-my-suffix.model';

describe('Component Tests', () => {
    describe('AdresMySuffix Management Detail Component', () => {
        let comp: AdresMySuffixDetailComponent;
        let fixture: ComponentFixture<AdresMySuffixDetailComponent>;
        const route = ({ data: of({ adres: new AdresMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AdresMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AdresMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AdresMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.adres).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
