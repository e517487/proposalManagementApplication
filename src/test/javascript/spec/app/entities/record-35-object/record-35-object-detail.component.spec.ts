/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectDetailComponent } from 'app/entities/record-35-object/record-35-object-detail.component';
import { Record35Object } from 'app/shared/model/record-35-object.model';

describe('Component Tests', () => {
    describe('Record35Object Management Detail Component', () => {
        let comp: Record35ObjectDetailComponent;
        let fixture: ComponentFixture<Record35ObjectDetailComponent>;
        const route = ({ data: of({ record35Object: new Record35Object(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record35ObjectDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record35ObjectDetailComponent);
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
