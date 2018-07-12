/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringDeleteDialogComponent } from 'app/entities/record-55-scoring/record-55-scoring-delete-dialog.component';
import { Record55ScoringService } from 'app/entities/record-55-scoring/record-55-scoring.service';

describe('Component Tests', () => {
    describe('Record55Scoring Management Delete Component', () => {
        let comp: Record55ScoringDeleteDialogComponent;
        let fixture: ComponentFixture<Record55ScoringDeleteDialogComponent>;
        let service: Record55ScoringService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringDeleteDialogComponent]
            })
                .overrideTemplate(Record55ScoringDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record55ScoringDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record55ScoringService);
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
