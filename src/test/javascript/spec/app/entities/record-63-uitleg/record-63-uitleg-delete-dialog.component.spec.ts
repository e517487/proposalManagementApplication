/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { ProposalManagementApplicationTestModule } from '../../../test.module';
import { Record63UitlegDeleteDialogComponent } from 'app/entities/record-63-uitleg/record-63-uitleg-delete-dialog.component';
import { Record63UitlegService } from 'app/entities/record-63-uitleg/record-63-uitleg.service';

describe('Component Tests', () => {
    describe('Record63Uitleg Management Delete Component', () => {
        let comp: Record63UitlegDeleteDialogComponent;
        let fixture: ComponentFixture<Record63UitlegDeleteDialogComponent>;
        let service: Record63UitlegService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [ProposalManagementApplicationTestModule],
                declarations: [Record63UitlegDeleteDialogComponent]
            })
                .overrideTemplate(Record63UitlegDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(Record63UitlegDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(Record63UitlegService);
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
