/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegMySuffixDetailComponent } from 'app/entities/record-61-uitleg-my-suffix/record-61-uitleg-my-suffix-detail.component';
import { Record61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record61UitlegMySuffix Management Detail Component', () => {
        let comp: Record61UitlegMySuffixDetailComponent;
        let fixture: ComponentFixture<Record61UitlegMySuffixDetailComponent>;
        const route = ({ data: of({ record61Uitleg: new Record61UitlegMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record61UitlegMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record61UitlegMySuffixDetailComponent);
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
