/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectDeleteDialogComponent } from 'app/entities/record-35-object/record-35-object-delete-dialog.component';
import { Record35ObjectService } from 'app/entities/record-35-object/record-35-object.service';

describe('Component Tests', () => {
    describe('Record35Object Management Delete Component', () => {
        let comp: Record35ObjectDeleteDialogComponent;
        let fixture: ComponentFixture<Record35ObjectDeleteDialogComponent>;
        let service: Record35ObjectService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectDeleteDialogComponent]
            })
                .overrideTemplate(Record35ObjectDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record35ObjectDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record35ObjectService);
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
