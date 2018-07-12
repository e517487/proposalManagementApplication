/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilDetailComponent } from 'app/entities/record-30-inruil/record-30-inruil-detail.component';
import { Record30Inruil } from 'app/shared/model/record-30-inruil.model';

describe('Component Tests', () => {
    describe('Record30Inruil Management Detail Component', () => {
        let comp: Record30InruilDetailComponent;
        let fixture: ComponentFixture<Record30InruilDetailComponent>;
        const route = ({ data: of({ record30Inruil: new Record30Inruil(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record30InruilDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record30InruilDetailComponent);
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
