/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilMySuffixDetailComponent } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix-detail.component';
import { Record30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';

describe('Component Tests', () => {
    describe('Record30InruilMySuffix Management Detail Component', () => {
        let comp: Record30InruilMySuffixDetailComponent;
        let fixture: ComponentFixture<Record30InruilMySuffixDetailComponent>;
        const route = ({ data: of({ record30Inruil: new Record30InruilMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record30InruilMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record30InruilMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record30Inruil).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
