/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record25HerfinancieeringMySuffixDeleteDialogComponent } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix-delete-dialog.component';
import { Record25HerfinancieeringMySuffixService } from 'app/entities/record-25-herfinancieering-my-suffix/record-25-herfinancieering-my-suffix.service';

describe('Component Tests', () => {
    describe('Record25HerfinancieeringMySuffix Management Delete Component', () => {
        let comp: Record25HerfinancieeringMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record25HerfinancieeringMySuffixDeleteDialogComponent>;
        let service: Record25HerfinancieeringMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record25HerfinancieeringMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record25HerfinancieeringMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record25HerfinancieeringMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record25HerfinancieeringMySuffixService);
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
