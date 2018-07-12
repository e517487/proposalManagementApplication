/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegMySuffixDeleteDialogComponent } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix-delete-dialog.component';
import { Record63UitlegMySuffixService } from 'app/entities/record-63-uitleg-my-suffix/record-63-uitleg-my-suffix.service';

describe('Component Tests', () => {
    describe('Record63UitlegMySuffix Management Delete Component', () => {
        let comp: Record63UitlegMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record63UitlegMySuffixDeleteDialogComponent>;
        let service: Record63UitlegMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record63UitlegMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record63UitlegMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record63UitlegMySuffixService);
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
