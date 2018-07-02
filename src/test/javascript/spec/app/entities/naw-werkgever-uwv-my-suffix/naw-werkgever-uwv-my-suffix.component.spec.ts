/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { NawWerkgeverUWVMySuffixComponent } from 'app/entities/naw-werkgever-uwv-my-suffix/naw-werkgever-uwv-my-suffix.component';
import { NawWerkgeverUWVMySuffixService } from 'app/entities/naw-werkgever-uwv-my-suffix/naw-werkgever-uwv-my-suffix.service';
import { NawWerkgeverUWVMySuffix } from 'app/shared/model/naw-werkgever-uwv-my-suffix.model';

describe('Component Tests', () => {
    describe('NawWerkgeverUWVMySuffix Management Component', () => {
        let comp: NawWerkgeverUWVMySuffixComponent;
        let fixture: ComponentFixture<NawWerkgeverUWVMySuffixComponent>;
        let service: NawWerkgeverUWVMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [NawWerkgeverUWVMySuffixComponent],
                providers: []
            })
                .overrideTemplate(NawWerkgeverUWVMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(NawWerkgeverUWVMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(NawWerkgeverUWVMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new NawWerkgeverUWVMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.nawWerkgeverUWVS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
