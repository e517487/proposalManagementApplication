/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieMySuffixDetailComponent } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix-detail.component';
import { Record45RelatieMySuffix } from 'app/shared/model/record-45-relatie-my-suffix.model';

describe('Component Tests', () => {
    describe('Record45RelatieMySuffix Management Detail Component', () => {
        let comp: Record45RelatieMySuffixDetailComponent;
        let fixture: ComponentFixture<Record45RelatieMySuffixDetailComponent>;
        const route = ({ data: of({ record45Relatie: new Record45RelatieMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record45RelatieMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record45RelatieMySuffixDetailComponent);
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
