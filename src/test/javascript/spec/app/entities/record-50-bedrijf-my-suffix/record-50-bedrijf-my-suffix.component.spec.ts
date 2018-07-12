/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfMySuffixComponent } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix.component';
import { Record50BedrijfMySuffixService } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix.service';
import { Record50BedrijfMySuffix } from 'app/shared/model/record-50-bedrijf-my-suffix.model';

describe('Component Tests', () => {
    describe('Record50BedrijfMySuffix Management Component', () => {
        let comp: Record50BedrijfMySuffixComponent;
        let fixture: ComponentFixture<Record50BedrijfMySuffixComponent>;
        let service: Record50BedrijfMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfMySuffixComponent],
                providers: []
            })
                .overrideTemplate(Record50BedrijfMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(Record50BedrijfMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record50BedrijfMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new Record50BedrijfMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.record50Bedrijfs[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
