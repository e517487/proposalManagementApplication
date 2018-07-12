/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfMySuffixDetailComponent } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix-detail.component';
import { Record50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';

describe('Component Tests', () => {
    describe('Record50BedrijfMySuffix Management Detail Component', () => {
        let comp: Record50BedrijfMySuffixDetailComponent;
        let fixture: ComponentFixture<Record50BedrijfMySuffixDetailComponent>;
        const route = ({ data: of({ record50Bedrijf: new Record50BedrijfMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record50BedrijfMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record50BedrijfMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record50Bedrijf).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
