/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EndMySuffixDetailComponent } from 'app/entities/record-99-end-my-suffix/record-99-end-my-suffix-detail.component';
import { Record99EndMySuffix } from 'app/shared/model/record-99-end-my-suffix.model';

describe('Component Tests', () => {
    describe('Record99EndMySuffix Management Detail Component', () => {
        let comp: Record99EndMySuffixDetailComponent;
        let fixture: ComponentFixture<Record99EndMySuffixDetailComponent>;
        const route = ({ data: of({ record99End: new Record99EndMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EndMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record99EndMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record99EndMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record99End).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
