/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieMySuffixDeleteDialogComponent } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix-delete-dialog.component';
import { Record45RelatieMySuffixService } from 'app/entities/record-45-relatie-my-suffix/record-45-relatie-my-suffix.service';

describe('Component Tests', () => {
    describe('Record45RelatieMySuffix Management Delete Component', () => {
        let comp: Record45RelatieMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record45RelatieMySuffixDeleteDialogComponent>;
        let service: Record45RelatieMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record45RelatieMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record45RelatieMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record45RelatieMySuffixService);
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
