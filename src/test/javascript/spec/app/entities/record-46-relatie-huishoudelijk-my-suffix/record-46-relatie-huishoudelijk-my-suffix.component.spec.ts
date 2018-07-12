/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record46RelatieHuishoudelijkMySuffixComponent } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix.component';
import { Record46RelatieHuishoudelijkMySuffixService } from 'app/entities/record-46-relatie-huishoudelijk-my-suffix/record-46-relatie-huishoudelijk-my-suffix.service';
import { Record46RelatieHuishoudelijkMySuffix } from 'app/shared/model/record-46-relatie-huishoudelijk-my-suffix.model';

describe('Component Tests', () => {
    describe('Record46RelatieHuishoudelijkMySuffix Management Component', () => {
        let comp: Record46RelatieHuishoudelijkMySuffixComponent;
        let fixture: ComponentFixture<Record46RelatieHuishoudelijkMySuffixComponent>;
        let service: Record46RelatieHuishoudelijkMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record46RelatieHuishoudelijkMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record46RelatieHuishoudelijkMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record46RelatieHuishoudelijkMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record46RelatieHuishoudelijkMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record46RelatieHuishoudelijkMySuffix(123)],
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
