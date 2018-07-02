/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { WerksituatieMySuffixComponent } from 'app/entities/werksituatie-my-suffix/werksituatie-my-suffix.component';
import { WerksituatieMySuffixService } from 'app/entities/werksituatie-my-suffix/werksituatie-my-suffix.service';
import { WerksituatieMySuffix } from 'app/shared/model/werksituatie-my-suffix.model';

describe('Component Tests', () => {
    describe('WerksituatieMySuffix Management Component', () => {
        let comp: WerksituatieMySuffixComponent;
        let fixture: ComponentFixture<WerksituatieMySuffixComponent>;
        let service: WerksituatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [WerksituatieMySuffixComponent],
                providers: []
            })
                .overrideTemplate(WerksituatieMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(WerksituatieMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(WerksituatieMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new WerksituatieMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.werksituaties[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
