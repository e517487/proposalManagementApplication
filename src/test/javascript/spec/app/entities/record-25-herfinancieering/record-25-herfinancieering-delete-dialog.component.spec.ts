/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringDeleteDialogComponent } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering-delete-dialog.component';
import { Record25HerfinancieeringService } from 'app/entities/record-25-herfinancieering/record-25-herfinancieering.service';

describe('Component Tests', () => {
    describe('Record25Herfinancieering Management Delete Component', () => {
        let comp: Record25HerfinancieeringDeleteDialogComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringDeleteDialogComponent>;
        let service: Record25HerfinancieeringService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringDeleteDialogComponent]
            })
                .overrideTemplate(Record25HerfinancieeringDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record25HerfinancieeringDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record25HerfinancieeringService);
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
