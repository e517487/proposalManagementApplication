/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record50BedrijfDeleteDialogComponent } from 'app/entities/record-50-bedrijf/record-50-bedrijf-delete-dialog.component';
import { Record50BedrijfService } from 'app/entities/record-50-bedrijf/record-50-bedrijf.service';

describe('Component Tests', () => {
    describe('Record50Bedrijf Management Delete Component', () => {
        let comp: Record50BedrijfDeleteDialogComponent;
        let fixture: ComponentFixture<Record50BedrijfDeleteDialogComponent>;
        let service: Record50BedrijfService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record50BedrijfDeleteDialogComponent]
            })
                .overrideTemplate(Record50BedrijfDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record50BedrijfDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record50BedrijfService);
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
