/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record20FinancieelDeleteDialogComponent } from 'app/entities/record-20-financieel/record-20-financieel-delete-dialog.component';
import { Record20FinancieelService } from 'app/entities/record-20-financieel/record-20-financieel.service';

describe('Component Tests', () => {
    describe('Record20Financieel Management Delete Component', () => {
        let comp: Record20FinancieelDeleteDialogComponent;
        let fixture: ComponentFixture<Record20FinancieelDeleteDialogComponent>;
        let service: Record20FinancieelService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record20FinancieelDeleteDialogComponent]
            })
                .overrideTemplate(Record20FinancieelDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record20FinancieelDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record20FinancieelService);
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
