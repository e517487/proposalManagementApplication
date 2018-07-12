/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenDetailComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen-detail.component';
import { Record10AanvraagGegevensAlgemeen } from 'app/shared/model/record-10-aanvraag-gegevens-algemeen.model';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeen Management Detail Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenDetailComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenDetailComponent>;
        const route = ({
            data: of({ record10AanvraagGegevensAlgemeen: new Record10AanvraagGegevensAlgemeen(123) })
        } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenDetailComponent);
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
