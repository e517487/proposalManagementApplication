/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { VrijeTekstMySuffixDeleteDialogComponent } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix-delete-dialog.component';
import { VrijeTekstMySuffixService } from 'app/entities/vrije-tekst-my-suffix/vrije-tekst-my-suffix.service';

describe('Component Tests', () => {
    describe('VrijeTekstMySuffix Management Delete Component', () => {
        let comp: VrijeTekstMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<VrijeTekstMySuffixDeleteDialogComponent>;
        let service: VrijeTekstMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [VrijeTekstMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(VrijeTekstMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(VrijeTekstMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VrijeTekstMySuffixService);
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
