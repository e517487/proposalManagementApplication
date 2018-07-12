/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenDetailComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen-detail.component';
import { Record11AanvraagGegevensOpmerkingen } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen.model';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingen Management Detail Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenDetailComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenDetailComponent>;
        const route = ({
            data: of({ record11AanvraagGegevensOpmerkingen: new Record11AanvraagGegevensOpmerkingen(123) })
        } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.record11AanvraagGegevensOpmerkingen).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
