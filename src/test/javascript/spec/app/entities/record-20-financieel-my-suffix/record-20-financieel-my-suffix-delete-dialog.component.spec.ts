/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelMySuffixDeleteDialogComponent } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix-delete-dialog.component';
import { Record20FinancieelMySuffixService } from 'app/entities/record-20-financieel-my-suffix/record-20-financieel-my-suffix.service';

describe('Component Tests', () => {
    describe('Record20FinancieelMySuffix Management Delete Component', () => {
        let comp: Record20FinancieelMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record20FinancieelMySuffixDeleteDialogComponent>;
        let service: Record20FinancieelMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record20FinancieelMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record20FinancieelMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record20FinancieelMySuffixService);
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
