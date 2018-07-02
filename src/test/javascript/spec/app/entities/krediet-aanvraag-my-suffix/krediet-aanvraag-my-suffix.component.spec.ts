/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { KredietAanvraagMySuffixComponent } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix.component';
import { KredietAanvraagMySuffixService } from 'app/entities/krediet-aanvraag-my-suffix/krediet-aanvraag-my-suffix.service';
import { KredietAanvraagMySuffix } from 'app/shared/model/krediet-aanvraag-my-suffix.model';

describe('Component Tests', () => {
    describe('KredietAanvraagMySuffix Management Component', () => {
        let comp: KredietAanvraagMySuffixComponent;
        let fixture: ComponentFixture<KredietAanvraagMySuffixComponent>;
        let service: KredietAanvraagMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [KredietAanvraagMySuffixComponent],
                providers: []
            })
                .overrideTemplate(KredietAanvraagMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(KredietAanvraagMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(KredietAanvraagMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new KredietAanvraagMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.kredietAanvraags[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
