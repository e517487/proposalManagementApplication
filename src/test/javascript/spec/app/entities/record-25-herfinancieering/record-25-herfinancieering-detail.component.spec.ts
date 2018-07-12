/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringDetailComponent } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering-detail.component';
import { Record25Herfinancieering } from 'app/shared/model/record-25-herfinancieering.model';

describe('Component Tests', () => {
    describe('Record25Herfinancieering Management Detail Component', () => {
        let comp: Record25HerfinancieeringDetailComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringDetailComponent>;
        const route = ({ data: of({ record25Herfinancieering: new Record25Herfinancieering(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record25HerfinancieeringDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record25HerfinancieeringDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record25Herfinancieering).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
