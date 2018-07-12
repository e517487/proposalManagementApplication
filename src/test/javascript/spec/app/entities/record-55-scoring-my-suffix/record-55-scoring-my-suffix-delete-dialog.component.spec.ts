/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record55ScoringMySuffixDeleteDialogComponent } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix-delete-dialog.component';
import { Record55ScoringMySuffixService } from 'app/entities/record-55-scoring-my-suffix/record-55-scoring-my-suffix.service';

describe('Component Tests', () => {
    describe('Record55ScoringMySuffix Management Delete Component', () => {
        let comp: Record55ScoringMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record55ScoringMySuffixDeleteDialogComponent>;
        let service: Record55ScoringMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record55ScoringMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record55ScoringMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record55ScoringMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record55ScoringMySuffixService);
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
