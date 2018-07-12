/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindMySuffixDetailComponent } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix-detail.component';
import { Record99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';

describe('Component Tests', () => {
    describe('Record99EindMySuffix Management Detail Component', () => {
        let comp: Record99EindMySuffixDetailComponent;
        let fixture: ComponentFixture<Record99EindMySuffixDetailComponent>;
        const route = ({ data: of({ record99Eind: new Record99EindMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record99EindMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record99EindMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record99Eind).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
