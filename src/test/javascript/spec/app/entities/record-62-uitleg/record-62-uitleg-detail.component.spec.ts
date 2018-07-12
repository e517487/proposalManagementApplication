/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegDetailComponent } from 'app/entities/record-62-uitleg/record-62-uitleg-detail.component';
import { Record62Uitleg } from 'app/shared/model/record-62-uitleg.model';

describe('Component Tests', () => {
    describe('Record62Uitleg Management Detail Component', () => {
        let comp: Record62UitlegDetailComponent;
        let fixture: ComponentFixture<Record62UitlegDetailComponent>;
        const route = ({ data: of({ record62Uitleg: new Record62Uitleg(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record62UitlegDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record62UitlegDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record62Uitleg).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
