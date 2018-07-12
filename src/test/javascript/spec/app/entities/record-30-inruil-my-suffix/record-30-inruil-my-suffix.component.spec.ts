/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilMySuffixComponent } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix.component';
import { Record30InruilMySuffixService } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix.service';
import { Record30InruilMySuffix } from 'app/shared/model/record-30-inruil-my-suffix.model';

describe('Component Tests', () => {
    describe('Record30InruilMySuffix Management Component', () => {
        let comp: Record30InruilMySuffixComponent;
        let fixture: ComponentFixture<Record30InruilMySuffixComponent>;
        let service: Record30InruilMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record30InruilMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record30InruilMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record30InruilMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record30InruilMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record30Inruils[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
