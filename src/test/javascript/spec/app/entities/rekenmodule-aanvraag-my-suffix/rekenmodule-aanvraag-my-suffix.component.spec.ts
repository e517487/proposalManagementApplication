/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RekenmoduleAanvraagMySuffixComponent } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix.component';
import { RekenmoduleAanvraagMySuffixService } from 'app/entities/rekenmodule-aanvraag-my-suffix/rekenmodule-aanvraag-my-suffix.service';
import { RekenmoduleAanvraagMySuffix } from 'app/shared/model/rekenmodule-aanvraag-my-suffix.model';

describe('Component Tests', () => {
    describe('RekenmoduleAanvraagMySuffix Management Component', () => {
        let comp: RekenmoduleAanvraagMySuffixComponent;
        let fixture: ComponentFixture<RekenmoduleAanvraagMySuffixComponent>;
        let service: RekenmoduleAanvraagMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RekenmoduleAanvraagMySuffixComponent],
                providers: []
            })
                .overrideTemplate(RekenmoduleAanvraagMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RekenmoduleAanvraagMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RekenmoduleAanvraagMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new RekenmoduleAanvraagMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.rekenmoduleAanvraags[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
