/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record99EindMySuffixDeleteDialogComponent } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix-delete-dialog.component';
import { Record99EindMySuffixService } from 'app/entities/record-99-eind-my-suffix/record-99-eind-my-suffix.service';

describe('Component Tests', () => {
    describe('Record99EindMySuffix Management Delete Component', () => {
        let comp: Record99EindMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<Record99EindMySuffixDeleteDialogComponent>;
        let service: Record99EindMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record99EindMySuffixDeleteDialogComponent]
            })
                .overrideTemplate(Record99EindMySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record99EindMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record99EindMySuffixService);
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
