/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix-delete-dialog.component';
import { Record10AanvraagGegevensAlgemeenMySuffixService } from 'app/entities/record-10-aanvraag-gegevens-algemeen-my-suffix/record-10-aanvraag-gegevens-algemeen-my-suffix.service';

describe('Component Tests', () => {
    describe('Record10AanvraagGegevensAlgemeenMySuffix Management Delete Component', () => {
        let comp: Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent>;
        let service: Record10AanvraagGegevensAlgemeenMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record10AanvraagGegevensAlgemeenMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record10AanvraagGegevensAlgemeenMySuffixService);
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
