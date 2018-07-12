/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegMySuffixDetailComponent } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix-detail.component';
import { Record63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record63UitlegMySuffix Management Detail Component', () => {
        let comp: Record63UitlegMySuffixDetailComponent;
        let fixture: ComponentFixture<Record63UitlegMySuffixDetailComponent>;
        const route = ({ data: of({ record63Uitleg: new Record63UitlegMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record63UitlegMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record63UitlegMySuffixDetailComponent);
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
