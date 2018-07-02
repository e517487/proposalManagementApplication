/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { FdnAanvragerMySuffixDeleteDialogComponent } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix-delete-dialog.component';
import { FdnAanvragerMySuffixService } from 'app/entities/fdn-aanvrager-my-suffix/fdn-aanvrager-my-suffix.service';

describe('Component Tests', () => {
    describe('FdnAanvragerMySuffix Management Delete Component', () => {
        let comp: FdnAanvragerMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<FdnAanvragerMySuffixDeleteDialogComponent>;
        let service: FdnAanvragerMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [FdnAanvragerMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(FdnAanvragerMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(FdnAanvragerMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FdnAanvragerMySuffixService);
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
