/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AanvraagberichtMySuffixComponent } from 'app/entities/aanvraagbericht-my-suffix/aanvraagbericht-my-suffix.component';
import { AanvraagberichtMySuffixService } from 'app/entities/aanvraagbericht-my-suffix/aanvraagbericht-my-suffix.service';
import { AanvraagberichtMySuffix } from 'app/shared/model/aanvraagbericht-my-suffix.model';

describe('Component Tests', () => {
    describe('AanvraagberichtMySuffix Management Component', () => {
        let comp: AanvraagberichtMySuffixComponent;
        let fixture: ComponentFixture<AanvraagberichtMySuffixComponent>;
        let service: AanvraagberichtMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AanvraagberichtMySuffixComponent],
                providers: []
            })
                .overrideTemplate(AanvraagberichtMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AanvraagberichtMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AanvraagberichtMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new AanvraagberichtMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.aanvraagberichts[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
