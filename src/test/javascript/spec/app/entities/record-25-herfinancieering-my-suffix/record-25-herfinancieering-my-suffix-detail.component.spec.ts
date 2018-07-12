/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringMySuffixDetailComponent } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix-detail.component';
import { Record25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';

describe('Component Tests', () => {
    describe('Record25HerfinancieeringMySuffix Management Detail Component', () => {
        let comp: Record25HerfinancieeringMySuffixDetailComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringMySuffixDetailComponent>;
        const route = ({ data: of({ record25Herfinancieering: new Record25HerfinancieeringMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record25HerfinancieeringMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record25HerfinancieeringMySuffixDetailComponent);
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
