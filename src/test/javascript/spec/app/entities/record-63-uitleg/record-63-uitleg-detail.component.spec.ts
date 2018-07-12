/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegDetailComponent } from 'app/entities/record-63-uitleg/record-63-uitleg-detail.component';
import { Record63Uitleg } from 'app/shared/model/record-63-uitleg.model';

describe('Component Tests', () => {
    describe('Record63Uitleg Management Detail Component', () => {
        let comp: Record63UitlegDetailComponent;
        let fixture: ComponentFixture<Record63UitlegDetailComponent>;
        const route = ({ data: of({ record63Uitleg: new Record63Uitleg(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record63UitlegDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record63UitlegDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record63Uitleg).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
