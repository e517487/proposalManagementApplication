/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { LegitimatiebewijsMySuffixDeleteDialogComponent } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix-delete-dialog.component';
import { LegitimatiebewijsMySuffixService } from 'app/entities/legitimatiebewijs-my-suffix/legitimatiebewijs-my-suffix.service';

describe('Component Tests', () => {
    describe('LegitimatiebewijsMySuffix Management Delete Component', () => {
        let comp: LegitimatiebewijsMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<LegitimatiebewijsMySuffixDeleteDialogComponent>;
        let service: LegitimatiebewijsMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [LegitimatiebewijsMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(LegitimatiebewijsMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(LegitimatiebewijsMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(LegitimatiebewijsMySuffixService);
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
