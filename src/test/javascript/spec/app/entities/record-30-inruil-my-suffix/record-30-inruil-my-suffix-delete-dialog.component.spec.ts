/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record30InruilMySuffixDeleteDialogComponent } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix-delete-dialog.component';
import { Record30InruilMySuffixService } from 'app/entities/record-30-inruil-my-suffix/record-30-inruil-my-suffix.service';

describe('Component Tests', () => {
    describe('Record30InruilMySuffix Management Delete Component', () => {
        let comp: Record30InruilMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record30InruilMySuffixDeleteDialogComponent>;
        let service: Record30InruilMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record30InruilMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record30InruilMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record30InruilMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record30InruilMySuffixService);
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
