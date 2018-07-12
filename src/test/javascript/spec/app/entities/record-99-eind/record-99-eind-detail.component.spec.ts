/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindDetailComponent } from 'app/entities/record-99-eind/record-99-eind-detail.component';
import { Record99Eind } from 'app/shared/model/record-99-eind.model';

describe('Component Tests', () => {
    describe('Record99Eind Management Detail Component', () => {
        let comp: Record99EindDetailComponent;
        let fixture: ComponentFixture<Record99EindDetailComponent>;
        const route = ({ data: of({ record99Eind: new Record99Eind(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record99EindDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record99EindDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record99Eind).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
