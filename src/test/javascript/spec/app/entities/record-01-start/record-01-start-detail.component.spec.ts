/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record01StartDetailComponent } from 'app/entities/record-01-start/record-01-start-detail.component';
import { Record01Start } from 'app/shared/model/record-01-start.model';

describe('Component Tests', () => {
    describe('Record01Start Management Detail Component', () => {
        let comp: Record01StartDetailComponent;
        let fixture: ComponentFixture<Record01StartDetailComponent>;
        const route = ({ data: of({ record01Start: new Record01Start(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record01StartDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record01StartDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record01StartDetailComponent);
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
