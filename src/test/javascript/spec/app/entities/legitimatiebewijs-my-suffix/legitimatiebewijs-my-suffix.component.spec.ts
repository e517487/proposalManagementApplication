/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { LegitimatiebewijsMySuffixComponent } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix.component';
import { LegitimatiebewijsMySuffixService } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix.service';
import { LegitimatiebewijsMySuffix } from 'app/shared/model/legitimatiebewijs-my-suffix.model';

describe('Component Tests', () => {
    describe('LegitimatiebewijsMySuffix Management Component', () => {
        let comp: LegitimatiebewijsMySuffixComponent;
        let fixture: ComponentFixture<LegitimatiebewijsMySuffixComponent>;
        let service: LegitimatiebewijsMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [LegitimatiebewijsMySuffixComponent],
                providers: []
            })
                .overrideTemplate(LegitimatiebewijsMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(LegitimatiebewijsMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(LegitimatiebewijsMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new LegitimatiebewijsMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.legitimatiebewijs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
