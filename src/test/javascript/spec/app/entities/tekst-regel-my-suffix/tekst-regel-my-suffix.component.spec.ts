/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { TekstRegelMySuffixComponent } from 'app/entities/tekst-regel-my-suffix/tekst-regel-my-suffix.component';
import { TekstRegelMySuffixService } from 'app/entities/tekst-regel-my-suffix/tekst-regel-my-suffix.service';
import { TekstRegelMySuffix } from 'app/shared/model/tekst-regel-my-suffix.model';

describe('Component Tests', () => {
    describe('TekstRegelMySuffix Management Component', () => {
        let comp: TekstRegelMySuffixComponent;
        let fixture: ComponentFixture<TekstRegelMySuffixComponent>;
        let service: TekstRegelMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [TekstRegelMySuffixComponent],
                providers: []
            })
                .overrideTemplate(TekstRegelMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(TekstRegelMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TekstRegelMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new TekstRegelMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.tekstRegels[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
