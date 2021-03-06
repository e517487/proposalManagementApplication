/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record62UitlegMySuffixComponent } from 'app/entities/record-62-uitleg-my-suffix/record-62-uitleg-my-suffix.component';
import { Record62UitlegMySuffixService } from 'app/entities/record-62-uitleg-my-suffix/record-62-uitleg-my-suffix.service';
import { Record62UitlegMySuffix } from 'app/shared/model/record-62-uitleg-my-suffix.model';

describe('Component Tests', () => {
    describe('Record62UitlegMySuffix Management Component', () => {
        let comp: Record62UitlegMySuffixComponent;
        let fixture: ComponentFixture<Record62UitlegMySuffixComponent>;
        let service: Record62UitlegMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record62UitlegMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record62UitlegMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record62UitlegMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record62UitlegMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record62UitlegMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record62Uitlegs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
