/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieDetailComponent } from 'app/entities/record-45-relatie/record-45-relatie-detail.component';
import { Record45Relatie } from 'app/shared/model/record-45-relatie.model';

describe('Component Tests', () => {
    describe('Record45Relatie Management Detail Component', () => {
        let comp: Record45RelatieDetailComponent;
        let fixture: ComponentFixture<Record45RelatieDetailComponent>;
        const route = ({ data: of({ record45Relatie: new Record45Relatie(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record45RelatieDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record45RelatieDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record45Relatie).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
