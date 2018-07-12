/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenDeleteDialogComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen-delete-dialog.component';
import { Record11AanvraagGegevensOpmerkingenService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen/record-11-aanvraag-gegevens-opmerkingen.service';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingen Management Delete Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenDeleteDialogComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenDeleteDialogComponent>;
        let service: Record11AanvraagGegevensOpmerkingenService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenDeleteDialogComponent]
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record11AanvraagGegevensOpmerkingenService);
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
