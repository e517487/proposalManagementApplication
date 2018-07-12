/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix-delete-dialog.component';
import { Record11AanvraagGegevensOpmerkingenMySuffixService } from 'app/entities/record-11-aanvraag-gegevens-opmerkingen-my-suffix/record-11-aanvraag-gegevens-opmerkingen-my-suffix.service';

describe('Component Tests', () => {
    describe('Record11AanvraagGegevensOpmerkingenMySuffix Management Delete Component', () => {
        let comp: Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent>;
        let service: Record11AanvraagGegevensOpmerkingenMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record11AanvraagGegevensOpmerkingenMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record11AanvraagGegevensOpmerkingenMySuffixService);
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
