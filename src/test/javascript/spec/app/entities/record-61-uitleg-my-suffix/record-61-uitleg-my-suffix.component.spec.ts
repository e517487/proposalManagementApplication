/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record61UitlegMySuffixComponent } from 'app/entities/record-61-uitleg-my-suffix/record-61-uitleg-my-suffix.component';
import { Record61UitlegMySuffixService } from 'app/entities/record-61-uitleg-my-suffix/record-61-uitleg-my-suffix.service';
import { Record61UitlegMySuffix } from 'app/shared/model/record-61-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record61UitlegMySuffix Management Component', () => {
        let comp: Record61UitlegMySuffixComponent;
        let fixture: ComponentFixture<Record61UitlegMySuffixComponent>;
        let service: Record61UitlegMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record61UitlegMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record61UitlegMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record61UitlegMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record61UitlegMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record61UitlegMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record61Uitlegs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
