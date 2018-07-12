/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenDeleteDialogComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen-delete-dialog.component';
import { Record10AanvraagGegevensAlgemeenService } from 'app/entities/record-10-aanvraag-gegevens-algemeen/record-10-aanvraag-gegevens-algemeen.service';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeen Management Delete Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenDeleteDialogComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenDeleteDialogComponent>;
        let service: Record10AanvraagGegevensAlgemeenService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenDeleteDialogComponent]
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record10AanvraagGegevensAlgemeenService);
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
