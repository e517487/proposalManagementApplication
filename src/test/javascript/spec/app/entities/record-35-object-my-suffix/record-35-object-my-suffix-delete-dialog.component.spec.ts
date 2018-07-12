/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record35ObjectMySuffixDeleteDialogComponent } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix-delete-dialog.component';
import { Record35ObjectMySuffixService } from 'app/entities/record-35-object-my-suffix/record-35-object-my-suffix.service';

describe('Component Tests', () => {
    describe('Record35ObjectMySuffix Management Delete Component', () => {
        let comp: Record35ObjectMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record35ObjectMySuffixDeleteDialogComponent>;
        let service: Record35ObjectMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record35ObjectMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record35ObjectMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record35ObjectMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record35ObjectMySuffixService);
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
