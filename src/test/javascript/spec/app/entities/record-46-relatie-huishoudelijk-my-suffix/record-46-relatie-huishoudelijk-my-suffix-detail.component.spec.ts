/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkMySuffixDetailComponent } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix-detail.component';
import { Record46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijkMySuffix Management Detail Component', () => {
        let comp: Record46RelatieHuishoudelijkMySuffixDetailComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkMySuffixDetailComponent>;
        const route = ({
            data: of({ record46RelatieHuishoudelijk: new Record46RelatieHuishoudelijkMySuffix(123) })
        } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record46RelatieHuishoudelijkMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkMySuffixDetailComponent);
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
