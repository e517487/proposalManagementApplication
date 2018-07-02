/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { CreditScoreMySuffixComponent } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix.component';
import { CreditScoreMySuffixService } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix.service';
import { CreditScoreMySuffix } from 'app/shared/model/credit-score-my-suffix.model';

describe('Component Tests', () => {
    describe('CreditScoreMySuffix Management Component', () => {
        let comp: CreditScoreMySuffixComponent;
        let fixture: ComponentFixture<CreditScoreMySuffixComponent>;
        let service: CreditScoreMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [CreditScoreMySuffixComponent],
                providers: []
            })
                .overrideTemplate(CreditScoreMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(CreditScoreMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CreditScoreMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new CreditScoreMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.creditScores[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
