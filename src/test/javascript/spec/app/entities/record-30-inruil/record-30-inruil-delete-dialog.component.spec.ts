/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilDeleteDialogComponent } from 'app/entities/record-30-inruil/record-30-inruil-delete-dialog.component';
import { Record30InruilService } from 'app/entities/record-30-inruil/record-30-inruil.service';

describe('Component Tests', () => {
    describe('Record30Inruil Management Delete Component', () => {
        let comp: Record30InruilDeleteDialogComponent;
        let fixture: ComponentFixture<Record30InruilDeleteDialogComponent>;
        let service: Record30InruilService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilDeleteDialogComponent]
            })
                .overrideTemplate(Record30InruilDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record30InruilDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record30InruilService);
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
