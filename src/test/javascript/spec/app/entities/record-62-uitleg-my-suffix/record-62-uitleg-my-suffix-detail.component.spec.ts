/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegMySuffixDetailComponent } from 'app/entities/record-62-uitleg-my-suffix/record-62-uitleg-my-suffix-detail.component';
import { Record62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record62UitlegMySuffix Management Detail Component', () => {
        let comp: Record62UitlegMySuffixDetailComponent;
        let fixture: ComponentFixture<Record62UitlegMySuffixDetailComponent>;
        const route = ({ data: of({ record62Uitleg: new Record62UitlegMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record62UitlegMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record62UitlegMySuffixDetailComponent);
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
