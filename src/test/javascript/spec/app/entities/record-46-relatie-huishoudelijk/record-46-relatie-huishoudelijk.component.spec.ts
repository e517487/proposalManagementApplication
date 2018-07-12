/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkComponent } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk.component';
import { Record46RelatieHuishoudelijkService } from 'app/entities/record-46-relatie-huishoudelijk/record-46-relatie-huishoudelijk.service';
import { Record46RelatieHuishoudelijk } from 'app/shared/model/record-46-relatie-huishoudelijk.model';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijk Management Component', () => {
        let comp: Record46RelatieHuishoudelijkComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkComponent>;
        let service: Record46RelatieHuishoudelijkService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkComponent],
                providers: []
            })
                .overrideTemplate(Record46RelatieHuishoudelijkComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record46RelatieHuishoudelijkService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record46RelatieHuishoudelijk(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record46RelatieHuishoudelijks[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
