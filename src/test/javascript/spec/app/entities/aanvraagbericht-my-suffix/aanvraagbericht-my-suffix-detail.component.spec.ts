/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AanvraagberichtMySuffixDetailComponent } from 'app/entities/aanvraagbericht-my-suffix/aanvraagbericht-my-suffix-detail.component';
import { AanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';

describe('Component Tests', () => {
    describe('AanvraagberichtMySuffix Management Detail Component', () => {
        let comp: AanvraagberichtMySuffixDetailComponent;
        let fixture: ComponentFixture<AanvraagberichtMySuffixDetailComponent>;
        const route = ({ data: of({ aanvraagbericht: new AanvraagberichtMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AanvraagberichtMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(AanvraagberichtMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(AanvraagberichtMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.aanvraagbericht).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
