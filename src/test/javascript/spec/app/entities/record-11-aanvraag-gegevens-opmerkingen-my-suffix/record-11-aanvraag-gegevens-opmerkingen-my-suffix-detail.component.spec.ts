/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix-detail.component';
import { Record11AanvraagGegevensOpmerkingenMySuffix } from 'app/shared/model/record-11-aanvraag-gegevens-opmerkingen-my-suffix.model';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingenMySuffix Management Detail Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent>;
        const route = ({
            data: of({ record11AanvraagGegevensOpmerkingen: new Record11AanvraagGegevensOpmerkingenMySuffix(123) })
        } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenMySuffixDetailComponent);
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
