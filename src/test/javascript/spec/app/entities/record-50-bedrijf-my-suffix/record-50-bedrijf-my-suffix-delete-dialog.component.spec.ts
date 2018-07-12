/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfMySuffixDeleteDialogComponent } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix-delete-dialog.component';
import { Record50BedrijfMySuffixService } from 'app/entities/record-50-bedrijf-my-suffix/record-50-bedrijf-my-suffix.service';

describe('Component Tests', () => {
    describe('Record50BedrijfMySuffix Management Delete Component', () => {
        let comp: Record50BedrijfMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record50BedrijfMySuffixDeleteDialogComponent>;
        let service: Record50BedrijfMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record50BedrijfMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record50BedrijfMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record50BedrijfMySuffixService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it(
                'Should call delete service on confirmDelete',
                inject(
                    [],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });
});
