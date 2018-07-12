/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record45RelatieDeleteDialogComponent } from 'app/entities/record-45-relatie/record-45-relatie-delete-dialog.component';
import { Record45RelatieService } from 'app/entities/record-45-relatie/record-45-relatie.service';

describe('Component Tests', () => {
    describe('Record45Relatie Management Delete Component', () => {
        let comp: Record45RelatieDeleteDialogComponent;
        let fixture: ComponentFixture<Record45RelatieDeleteDialogComponent>;
        let service: Record45RelatieService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record45RelatieDeleteDialogComponent]
            })
                .overrideTemplate(Record45RelatieDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record45RelatieDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record45RelatieService);
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
