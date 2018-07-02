/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { VrijeTekstMySuffixComponent } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix.component';
import { VrijeTekstMySuffixService } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix.service';
import { VrijeTekstMySuffix } from 'app/shared/model/vrije-tekst-my-suffix.model';

describe('Component Tests', () => {
    describe('VrijeTekstMySuffix Management Component', () => {
        let comp: VrijeTekstMySuffixComponent;
        let fixture: ComponentFixture<VrijeTekstMySuffixComponent>;
        let service: VrijeTekstMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [VrijeTekstMySuffixComponent],
                providers: []
            })
                .overrideTemplate(VrijeTekstMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(VrijeTekstMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VrijeTekstMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new VrijeTekstMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.vrijeTeksts[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
