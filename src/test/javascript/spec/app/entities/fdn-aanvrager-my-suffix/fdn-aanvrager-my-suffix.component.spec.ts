/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FdnAanvragerMySuffixComponent } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix.component';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix.service';
import { FdnAanvragerMySuffix } from 'app/shared/model/fdn-aanvrager-my-suffix.model';

describe('Component Tests', () => {
    describe('FdnAanvragerMySuffix Management Component', () => {
        let comp: FdnAanvragerMySuffixComponent;
        let fixture: ComponentFixture<FdnAanvragerMySuffixComponent>;
        let service: FdnAanvragerMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FdnAanvragerMySuffixComponent],
                providers: []
            })
                .overrideTemplate(FdnAanvragerMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(FdnAanvragerMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FdnAanvragerMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new FdnAanvragerMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.fdnAanvragers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
