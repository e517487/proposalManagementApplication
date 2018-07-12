/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record01StartMySuffixDetailComponent } from 'app/entities/record-01-start-my-suffix/record-01-start-my-suffix-detail.component';
import { Record01StartMySuffix } from 'app/shared/model/record-01-start-my-suffix.model';

describe('Component Tests', () => {
    describe('Record01StartMySuffix Management Detail Component', () => {
        let comp: Record01StartMySuffixDetailComponent;
        let fixture: ComponentFixture<Record01StartMySuffixDetailComponent>;
        const route = ({ data: of({ record01Start: new Record01StartMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record01StartMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record01StartMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record01StartMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record01Start).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
