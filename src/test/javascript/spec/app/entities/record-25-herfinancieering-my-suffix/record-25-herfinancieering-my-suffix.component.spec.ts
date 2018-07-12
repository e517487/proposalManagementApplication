/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringMySuffixComponent } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix.component';
import { Record25HerfinancieeringMySuffixService } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix.service';
import { Record25HerfinancieeringMySuffix } from 'app/shared/model/record-25-herfinancieering-my-suffix.model';

describe('Component Tests', () => {
    describe('Record25HerfinancieeringMySuffix Management Component', () => {
        let comp: Record25HerfinancieeringMySuffixComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringMySuffixComponent>;
        let service: Record25HerfinancieeringMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record25HerfinancieeringMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record25HerfinancieeringMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record25HerfinancieeringMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record25HerfinancieeringMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record25Herfinancieerings[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
