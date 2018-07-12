/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkDetailComponent } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk-detail.component';
import { Record46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijk Management Detail Component', () => {
        let comp: Record46RelatieHuishoudelijkDetailComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkDetailComponent>;
        const route = ({ data: of({ record46RelatieHuishoudelijk: new Record46RelatieHuishoudelijk(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record46RelatieHuishoudelijkDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record46RelatieHuishoudelijk).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
