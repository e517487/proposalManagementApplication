/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { AdresMySuffixComponent } from 'app/entities/adres-my-suffix/adres-my-suffix.component';
import { AdresMySuffixService } from 'app/entities/adres-my-suffix/adres-my-suffix.service';
import { AdresMySuffix } from 'app/shared/model/adres-my-suffix.model';

describe('Component Tests', () => {
    describe('AdresMySuffix Management Component', () => {
        let comp: AdresMySuffixComponent;
        let fixture: ComponentFixture<AdresMySuffixComponent>;
        let service: AdresMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [AdresMySuffixComponent],
                providers: []
            })
                .overrideTemplate(AdresMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AdresMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AdresMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new AdresMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.adres[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
