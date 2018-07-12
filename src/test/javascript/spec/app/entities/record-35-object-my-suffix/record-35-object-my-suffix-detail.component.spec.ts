/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectMySuffixDetailComponent } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix-detail.component';
import { Record35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';

describe('Component Tests', () => {
    describe('Record35ObjectMySuffix Management Detail Component', () => {
        let comp: Record35ObjectMySuffixDetailComponent;
        let fixture: ComponentFixture<Record35ObjectMySuffixDetailComponent>;
        const route = ({ data: of({ record35Object: new Record35ObjectMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record35ObjectMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record35ObjectMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record35Object).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
