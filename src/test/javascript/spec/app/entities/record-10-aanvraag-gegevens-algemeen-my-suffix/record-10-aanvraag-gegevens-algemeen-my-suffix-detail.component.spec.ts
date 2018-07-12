/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenMySuffixDetailComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix-detail.component';
import { Record10AanvraagGegevensAlgemeenMySuffix } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen-my-suffix.model';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeenMySuffix Management Detail Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenMySuffixDetailComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenMySuffixDetailComponent>;
        const route = ({
            data: of({ record10AanvraagGegevensAlgemeen: new Record10AanvraagGegevensAlgemeenMySuffix(123) })
        } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record10AanvraagGegevensAlgemeen).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
