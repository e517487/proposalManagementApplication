/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegDetailComponent } from 'app/entities/record-61-uitleg/record-61-uitleg-detail.component';
import { Record61Uitleg } from 'app/shared/model/record-61-uitleg.model';

describe('Component Tests', () => {
    describe('Record61Uitleg Management Detail Component', () => {
        let comp: Record61UitlegDetailComponent;
        let fixture: ComponentFixture<Record61UitlegDetailComponent>;
        const route = ({ data: of({ record61Uitleg: new Record61Uitleg(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record61UitlegDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record61UitlegDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record61Uitleg).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
