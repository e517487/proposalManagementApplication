/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreMySuffixDeleteDialogComponent } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix-delete-dialog.component';
import { Record40AcceptatieScoreMySuffixService } from 'app/entities/record-40-acceptatie-score-my-suffix/record-40-acceptatie-score-my-suffix.service';

describe('Component Tests', () => {
    describe('Record40AcceptatieScoreMySuffix Management Delete Component', () => {
        let comp: Record40AcceptatieScoreMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreMySuffixDeleteDialogComponent>;
        let service: Record40AcceptatieScoreMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record40AcceptatieScoreMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record40AcceptatieScoreMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record40AcceptatieScoreMySuffixService);
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
