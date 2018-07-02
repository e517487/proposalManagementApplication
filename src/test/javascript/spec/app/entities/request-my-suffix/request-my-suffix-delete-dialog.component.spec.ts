/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { RequestMySuffixDeleteDialogComponent } from 'app/entities/request-my-suffix/request-my-suffix-delete-dialog.component';
import { RequestMySuffixService } from 'app/entities/request-my-suffix/request-my-suffix.service';

describe('Component Tests', () => {
    describe('RequestMySuffix Management Delete Component', () => {
        let comp: RequestMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<RequestMySuffixDeleteDialogComponent>;
        let service: RequestMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [RequestMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(RequestMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(RequestMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RequestMySuffixService);
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
