/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { GezinssituatieMySuffixComponent } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix.component';
import { GezinssituatieMySuffixService } from 'app/entities/gezinssituatie-my-suffix/gezinssituatie-my-suffix.service';
import { GezinssituatieMySuffix } from 'app/shared/model/gezinssituatie-my-suffix.model';

describe('Component Tests', () => {
    describe('GezinssituatieMySuffix Management Component', () => {
        let comp: GezinssituatieMySuffixComponent;
        let fixture: ComponentFixture<GezinssituatieMySuffixComponent>;
        let service: GezinssituatieMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [GezinssituatieMySuffixComponent],
                providers: []
            })
                .overrideTemplate(GezinssituatieMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(GezinssituatieMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(GezinssituatieMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new GezinssituatieMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.gezinssituaties[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
