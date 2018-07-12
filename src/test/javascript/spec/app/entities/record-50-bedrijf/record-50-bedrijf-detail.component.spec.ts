/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfDetailComponent } from 'app/entities/record-50-bedrijf/record-50-bedrijf-detail.component';
import { Record50Bedrijf } from 'app/shared/model/record-50-bedrijf.model';

describe('Component Tests', () => {
    describe('Record50Bedrijf Management Detail Component', () => {
        let comp: Record50BedrijfDetailComponent;
        let fixture: ComponentFixture<Record50BedrijfDetailComponent>;
        const route = ({ data: of({ record50Bedrijf: new Record50Bedrijf(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record50BedrijfDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record50BedrijfDetailComponent);
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
