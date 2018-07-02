/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AlgemeenMySuffixComponent } from 'app/entities/algemeen-my-suffix/algemeen-my-suffix.component';
import { AlgemeenMySuffixService } from 'app/entities/algemeen-my-suffix/algemeen-my-suffix.service';
import { AlgemeenMySuffix } from 'app/shared/model/algemeen-my-suffix.model';

describe('Component Tests', () => {
    describe('AlgemeenMySuffix Management Component', () => {
        let comp: AlgemeenMySuffixComponent;
        let fixture: ComponentFixture<AlgemeenMySuffixComponent>;
        let service: AlgemeenMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AlgemeenMySuffixComponent],
                providers: []
            })
                .overrideTemplate(AlgemeenMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AlgemeenMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AlgemeenMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new AlgemeenMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.algemeens[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
