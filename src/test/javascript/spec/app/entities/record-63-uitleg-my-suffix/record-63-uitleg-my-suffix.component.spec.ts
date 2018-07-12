/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegMySuffixComponent } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix.component';
import { Record63UitlegMySuffixService } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix.service';
import { Record63UitlegMySuffix } from 'app/shared/model/record-63-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record63UitlegMySuffix Management Component', () => {
        let comp: Record63UitlegMySuffixComponent;
        let fixture: ComponentFixture<Record63UitlegMySuffixComponent>;
        let service: Record63UitlegMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record63UitlegMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record63UitlegMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record63UitlegMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record63UitlegMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record63Uitlegs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
