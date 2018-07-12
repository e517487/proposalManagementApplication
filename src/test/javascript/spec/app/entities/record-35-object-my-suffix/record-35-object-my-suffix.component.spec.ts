/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectMySuffixComponent } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix.component';
import { Record35ObjectMySuffixService } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix.service';
import { Record35ObjectMySuffix } from 'app/shared/model/record-35-object-my-suffix.model';

describe('Component Tests', () => {
    describe('Record35ObjectMySuffix Management Component', () => {
        let comp: Record35ObjectMySuffixComponent;
        let fixture: ComponentFixture<Record35ObjectMySuffixComponent>;
        let service: Record35ObjectMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record35ObjectMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record35ObjectMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record35ObjectMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record35ObjectMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record35Objects[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
