/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record40AcceptatieScoreDeleteDialogComponent } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score-delete-dialog.component';
import { Record40AcceptatieScoreService } from 'app/entities/record-40-acceptatie-score/record-40-acceptatie-score.service';

describe('Component Tests', () => {
    describe('Record40AcceptatieScore Management Delete Component', () => {
        let comp: Record40AcceptatieScoreDeleteDialogComponent;
        let fixture: ComponentFixture<Record40AcceptatieScoreDeleteDialogComponent>;
        let service: Record40AcceptatieScoreService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record40AcceptatieScoreDeleteDialogComponent]
            })
                .overrideTemplate(Record40AcceptatieScoreDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record40AcceptatieScoreDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record40AcceptatieScoreService);
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
