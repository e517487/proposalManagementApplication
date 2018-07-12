/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindMySuffixComponent } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix.component';
import { Record99EindMySuffixService } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix.service';
import { Record99EindMySuffix } from 'app/shared/model/record-99-eind-my-suffix.model';

describe('Component Tests', () => {
    describe('Record99EindMySuffix Management Component', () => {
        let comp: Record99EindMySuffixComponent;
        let fixture: ComponentFixture<Record99EindMySuffixComponent>;
        let service: Record99EindMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record99EindMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record99EindMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EindMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record99EindMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record99Einds[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
