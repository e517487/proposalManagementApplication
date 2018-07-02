/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FinancieleSituatieMySuffixComponent } from 'app/entities/financiele-situatie-my-suffix/financiele-situatie-my-suffix.component';
import { FinancieleSituatieMySuffixService } from 'app/entities/financiele-situatie-my-suffix/financiele-situatie-my-suffix.service';
import { FinancieleSituatieMySuffix } from 'app/shared/model/financiele-situatie-my-suffix.model';

describe('Component Tests', () => {
    describe('FinancieleSituatieMySuffix Management Component', () => {
        let comp: FinancieleSituatieMySuffixComponent;
        let fixture: ComponentFixture<FinancieleSituatieMySuffixComponent>;
        let service: FinancieleSituatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FinancieleSituatieMySuffixComponent],
                providers: []
            })
                .overrideTemplate(FinancieleSituatieMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(FinancieleSituatieMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FinancieleSituatieMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new FinancieleSituatieMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.financieleSituaties[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
