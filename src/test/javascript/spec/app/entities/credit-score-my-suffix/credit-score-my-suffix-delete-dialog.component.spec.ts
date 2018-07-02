/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { CreditScoreMySuffixDeleteDialogComponent } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix-delete-dialog.component';
import { CreditScoreMySuffixService } from 'app/entities/credit-score-my-suffix/credit-score-my-suffix.service';

describe('Component Tests', () => {
    describe('CreditScoreMySuffix Management Delete Component', () => {
        let comp: CreditScoreMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<CreditScoreMySuffixDeleteDialogComponent>;
        let service: CreditScoreMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [CreditScoreMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(CreditScoreMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CreditScoreMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CreditScoreMySuffixService);
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
